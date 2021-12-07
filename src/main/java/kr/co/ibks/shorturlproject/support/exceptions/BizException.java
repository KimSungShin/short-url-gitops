package kr.co.ibks.shorturlproject.support.exceptions;

import kr.co.ibks.shorturlproject.support.enums.ErrorCode;
import lombok.Getter;

public class BizException extends RuntimeException {
    @Getter
    private final ErrorCode errorCode;

    public BizException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BizException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
