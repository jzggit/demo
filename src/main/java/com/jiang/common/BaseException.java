package com.jiang.common;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {
    private String code;
    public BaseException(ErrorType errorType) {
        super(errorType.getMesg());
        this.code = errorType.getCode();
    }
}
