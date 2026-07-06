package ayaan.urlshortner.service;

import ayaan.urlshortner.entity.Url;

import java.util.List;

public interface UrlService{
    Url getOriginal(String shortUrl);

    boolean existUrl(String shortUrl);

    Url getShort(String baseUrl);

    Url createUrl(String baseUrl);
    List<Url> findAll();
    String deleteUrl(Long id);
}
