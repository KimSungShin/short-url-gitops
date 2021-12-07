package kr.co.ibks.shorturlproject.repository;

import kr.co.ibks.shorturlproject.domain.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    Optional<ShortUrl> findByHash(String hash);
}
