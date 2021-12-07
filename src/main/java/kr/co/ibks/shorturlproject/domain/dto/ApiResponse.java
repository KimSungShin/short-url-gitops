package kr.co.ibks.shorturlproject.domain.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int responseCode;
    private String responseMessage;
    private T result;

    public ApiResponse(int responseCode, String responseMessage, T result) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.result = result;
    }

}
