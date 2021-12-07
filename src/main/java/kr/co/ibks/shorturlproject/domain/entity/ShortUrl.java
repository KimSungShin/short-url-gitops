package kr.co.ibks.shorturlproject.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "short_url", indexes = {
        @Index(name = "idx_shorturl_hash_unq", columnList = "hash", unique = true)
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShortUrl extends Audity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hash", length = 20)
    private String hash;

    @Column(name = "url", length = 50)
    private String url;

    @Column(name = "origin_url", length = 300)
    private String originUrl;

    @Column(name = "memo", length = 500)
    private String memo;

    @Column(name = "expire_date")
    private LocalDate expireDate;

    @Builder
    public ShortUrl(String hash, String url, String originUrl, String memo, LocalDate expireDate) {
        this.hash = hash;
        this.url = url;
        this.originUrl = originUrl;
        this.memo = memo;
        this.expireDate = expireDate;
    }
}
