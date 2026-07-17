package ayaan.urlshortner.controller;


import ayaan.urlshortner.dto.UrlDto;
import ayaan.urlshortner.entity.Url;
import ayaan.urlshortner.service.UrlServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class UrlController {
    private final UrlServiceImpl service;
    private final String baseUrl = "http://localhost:8080/url/";
    public UrlController(UrlServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String openBasePage(){
        return "index";
    }

    @GetMapping("/url/{shortUrl}")
    public String getUrl(@PathVariable String shortUrl){
        Url url = service.getOriginal(shortUrl);
        if (url == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "URL not found");
        }
        return "redirect:" + url.getBaseUrl();
    }
    @GetMapping("/home")
    public String showHome(Model model){

        model.addAttribute("urldto",new UrlDto());
        return "homepage";

    }

    @PostMapping("/home")
    public String submitForm(@ModelAttribute UrlDto urlDto, Model model) {
        Url url = service.createUrl(urlDto.getBaseUrl());
        urlDto.setShortUrl(url.getShortUrl());
        model.addAttribute("short",baseUrl+urlDto.getShortUrl());
        model.addAttribute("message", "Registration Done");
        model.addAttribute("urldto", new UrlDto());
        return "homepage";
    }

    @PostMapping("/redirect")
    public String redirectUrl(@ModelAttribute UrlDto urlDto){
        Url url = service.getOriginal(urlDto.getShortUrl());
        if(url != null){
            return "redirect:" + url.getBaseUrl();
        }
        else return "homepage";
    }
}
