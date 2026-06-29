package ayaan.urlshortner.repositery;

import ayaan.urlshortner.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url,Long> {
    Url findByShortUrl(String shortUrl);
    boolean existsByShortUrl(String name);
    Url findByBaseUrl(String baseUrl);
}
