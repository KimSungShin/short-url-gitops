package kr.co.ibks.shorturlproject.support.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode {
    NOT_FOUND_URL(4041, "요청하신 단축URL 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_REQUIRED_PARAMETERS(4001, "필수 파라미터가 누락되었습니다.", HttpStatus.BAD_REQUEST);

    @Getter private int code;
    @Getter private String message;
    @Getter private HttpStatus httpStatus;

    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
