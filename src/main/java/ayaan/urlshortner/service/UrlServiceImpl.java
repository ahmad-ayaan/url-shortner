package ayaan.urlshortner.service;

import ayaan.urlshortner.entity.Url;
import ayaan.urlshortner.repositery.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UrlServiceImpl implements UrlService{

    private final UrlRepository repository;

    public UrlServiceImpl(UrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public Url getOriginal(String shortUrl) {
         return repository.findByShortUrl(shortUrl);
    }

    @Override
    public boolean existUrl(String shortUrl) {
        return repository.existsByShortUrl(shortUrl);
    }

    @Override
    public Url getShort(String baseUrl) {
        return repository.findByBaseUrl(baseUrl);
    }

    @Override
    public Url createUrl(String baseUrl) {
        Url existing = repository.findByBaseUrl(baseUrl);
        if(existing != null){
            return existing;
        }
        else{
            Url url = new Url();
            String shortCode = generateShortCode();
            url.setBaseUrl(baseUrl);
            url.setShortUrl(shortCode);
            return repository.save(url);
        }
    }

    @Override
    public List<Url> findAll() {
        return repository.findAll();
    }

    @Override
    public String deleteUrl(Long id) {
            Url url = repository.findById(id).orElse(null);
            if(url != null) {
                repository.delete(url);
                return "Deleted Url with id: " + id;
            }
            else {
                return "Url not found with id: "+id;
            }
    }


    private String generateShortCode() {
        return UUID.randomUUID()
                .toString()
                .substring(0, 8);
    }


}
