package kr.co.ibks.shorturlproject;

import kr.co.ibks.shorturlproject.domain.dto.ShortUrlDto;
import kr.co.ibks.shorturlproject.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class InitDb {
    @Autowired
    ShortUrlService shortUrlService;

    @PostConstruct
    public void init() {

        for(int i =0; i < 25 ; i++) {
            ShortUrlDto.RegisterReq req = new ShortUrlDto.RegisterReq();
            req.setMemo(String.valueOf(i+1));
            req.setOriginUrl("https://naver.com");
            req.setExpireDate(LocalDate.now());
            shortUrlService.register(req);
        }
    }
}
