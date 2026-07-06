package ayaan.urlshortner.controller;

import ayaan.urlshortner.entity.Url;
import ayaan.urlshortner.service.UrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UrlService service;
    public AdminController(UrlService service){
        this.service = service;
    }

    @GetMapping("/getall")
    public List<Url> getAll(){
        return service.findAll();
    }
    @GetMapping("/deleteid/{id}")
    public String deleteUrlById(@PathVariable Long id){
        return service.deleteUrl(id);
    }
}
