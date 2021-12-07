package kr.co.ibks.shorturlproject.domain.dto;

import kr.co.ibks.shorturlproject.domain.entity.ShortUrl;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShortUrlDto {

    @Data
    public static class RegisterReq {
        @NotEmpty(message = "원본URL 정보는 필수 값입니다.")
        private String originUrl;
        @NotNull(message = "만료일자 정보는 필수 값입니다.")
        private LocalDate expireDate;
        private String memo;

    }

    @Data
    public static class Res {
        private Long id;
        private String hash;
        private String url;
        private String originUrl;
        private LocalDate expireDate;
        private String memo;
        private String createdDate;
        private String updatedDate;

        public Res(ShortUrl shortUrl) {
            id = shortUrl.getId();
            hash = shortUrl.getHash();
            url = shortUrl.getUrl();
            originUrl = shortUrl.getOriginUrl();
            expireDate = shortUrl.getExpireDate();
            memo = shortUrl.getMemo();
            createdDate = shortUrl.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            updatedDate = shortUrl.getUpdatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }

}
