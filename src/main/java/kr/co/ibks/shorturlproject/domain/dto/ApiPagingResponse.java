package kr.co.ibks.shorturlproject.domain.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class ApiPagingResponse<T> {
    private int responseCode;
    private String responseMessage;
    private List<T> result;
    private Paging paging;

    public ApiPagingResponse(int responseCode, String responseMessage, Page<T> pageResult) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.paging = new Paging(pageResult);
        this.result = pageResult.getContent();
    }

}
