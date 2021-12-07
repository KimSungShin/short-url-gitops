package kr.co.ibks.shorturlproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        SortHandlerMethodArgumentResolver sortHandlerMethodArgumentResolver = new SortHandlerMethodArgumentResolver();
        sortHandlerMethodArgumentResolver.setSortParameter("sortBy");
        sortHandlerMethodArgumentResolver.setPropertyDelimiter("-");

        PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver = new PageableHandlerMethodArgumentResolver(sortHandlerMethodArgumentResolver);
        pageableHandlerMethodArgumentResolver.setOneIndexedParameters(true);
        pageableHandlerMethodArgumentResolver.setMaxPageSize(500);
        pageableHandlerMethodArgumentResolver.setFallbackPageable(PageRequest.of(0, 10));
        pageableHandlerMethodArgumentResolver.setPageParameterName("pageNo");
        pageableHandlerMethodArgumentResolver.setSizeParameterName("pageSize");

        resolvers.add(pageableHandlerMethodArgumentResolver);
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }
}
