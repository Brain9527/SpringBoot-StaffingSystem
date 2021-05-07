package com.huang.error;

public class HttpException extends RuntimeException {
    protected Integer httpStatusCode = 500;
    protected Integer code;

    public HttpException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
