package ayaan.urlshortner.controller;


import ayaan.urlshortner.entity.Url;
import ayaan.urlshortner.service.UrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UrlControllerApi {

    private final UrlService service;


    public UrlControllerApi(UrlService service) {
        this.service = service;
    }
    @GetMapping("/url/{shortUrl}")
    public String getBaseUrl(@PathVariable String shortUrl){
        Url url = service.getOriginal(shortUrl);
        if(url != null){
            return url.getBaseUrl();
        }
        else{
            return "Url Not mapped";
        }
    }
}
