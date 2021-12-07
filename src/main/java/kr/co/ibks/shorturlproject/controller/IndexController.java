package kr.co.ibks.shorturlproject.controller;

import kr.co.ibks.shorturlproject.domain.dto.ShortUrlDto;
import kr.co.ibks.shorturlproject.service.ShortUrlService;
import kr.co.ibks.shorturlproject.support.enums.ErrorCode;
import kr.co.ibks.shorturlproject.support.exceptions.BizException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/")
@Controller
public class IndexController {

    private final ShortUrlService shortUrlService;

    @GetMapping
    public String index() {
        return "redirect:/view/short-urls/list";
    }

    @GetMapping("/{hash}")
    public String redirectShortUrl(@PathVariable("hash") String hash) {
        try {
            ShortUrlDto.Res res = shortUrlService.getShortUrlByHash(hash);
            return "redirect:" + res.getOriginUrl();
        }
        catch (BizException bizException) {
            ErrorCode errorCode = bizException.getErrorCode();
            if(errorCode == ErrorCode.NOT_FOUND_URL) {
                return "error/404";
            }
            else {
                return "error/500";
            }
        }
    }
}
