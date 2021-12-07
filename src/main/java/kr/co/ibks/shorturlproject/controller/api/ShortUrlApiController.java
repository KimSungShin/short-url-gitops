package kr.co.ibks.shorturlproject.controller.api;

import kr.co.ibks.shorturlproject.domain.dto.ApiPagingResponse;
import kr.co.ibks.shorturlproject.domain.dto.ApiResponse;
import kr.co.ibks.shorturlproject.domain.dto.ShortUrlDto;
import kr.co.ibks.shorturlproject.domain.entity.ShortUrl;
import kr.co.ibks.shorturlproject.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/short-urls")
@RestController
public class ShortUrlApiController {
    private final ShortUrlService shortUrlService;

    @GetMapping
    public ApiPagingResponse<ShortUrlDto.Res> retrieve(Pageable pageable) {
        Page<ShortUrl> shortUrls = shortUrlService.list(pageable);
        List<ShortUrlDto.Res> resList = shortUrls.getContent().stream().map(ShortUrlDto.Res::new).collect(Collectors.toList());
        return new ApiPagingResponse<>(200,"Success",  new PageImpl<>(resList, shortUrls.getPageable() ,shortUrls.getTotalElements()));
    }

    @PostMapping
    public ApiResponse<ShortUrlDto.Res> register(@Valid @RequestBody ShortUrlDto.RegisterReq req) {
        ShortUrlDto.Res res = shortUrlService.register(req);
        return new ApiResponse<>(201, "Success", res);
    }
}
