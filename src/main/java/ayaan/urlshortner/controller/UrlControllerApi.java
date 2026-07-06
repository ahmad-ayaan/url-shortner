package ayaan.urlshortner.controller;


import ayaan.urlshortner.entity.Url;
import ayaan.urlshortner.service.UrlService;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/generate/")
    public String generateUrl(@RequestParam String baseUrl){
        Url url = service.createUrl(baseUrl);
        return url.getShortUrl();
    }
}
