package ayaan.urlshortner.service;

import ayaan.urlshortner.entity.Url;
import ayaan.urlshortner.repositery.UrlRepository;

public interface UrlService{
    Url getOriginal(String shortUrl);

    boolean existUrl(String shortUrl);

    Url getShort(String baseUrl);

    Url createUrl(String baseUrl);

}
