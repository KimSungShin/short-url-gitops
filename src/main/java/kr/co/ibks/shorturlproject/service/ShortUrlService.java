package kr.co.ibks.shorturlproject.service;

import kr.co.ibks.shorturlproject.domain.dto.ShortUrlDto;
import kr.co.ibks.shorturlproject.domain.entity.ShortUrl;
import kr.co.ibks.shorturlproject.repository.ShortUrlRepository;
import kr.co.ibks.shorturlproject.support.enums.ErrorCode;
import kr.co.ibks.shorturlproject.support.exceptions.BizException;
import kr.co.ibks.shorturlproject.support.utils.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ShortUrlService {
    private final ShortUrlRepository shortUrlRepository;

    public Page<ShortUrl> list(Pageable pageable) {
        return shortUrlRepository.findAll(pageable);
    }

    public ShortUrlDto.Res register(ShortUrlDto.RegisterReq req) {
        String hash = RandomGenerator.generate(6);
        ShortUrl shortUrl = ShortUrl.builder()
                .originUrl(req.getOriginUrl())
                .memo(req.getMemo())
                .url(String.format("http://localhost:8080/%s", hash))
                .expireDate(req.getExpireDate())
                .hash(hash)
                .build();

        shortUrlRepository.save(shortUrl);
        return new ShortUrlDto.Res(shortUrl);
    }

    public ShortUrlDto.Res getShortUrlByHash(String hash) {
        ShortUrl shortUrl = shortUrlRepository.findByHash(hash).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND_URL));
        return new ShortUrlDto.Res(shortUrl);
    }
}
