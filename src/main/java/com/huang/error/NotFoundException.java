package com.huang.error;

public class NotFoundException extends HttpException {
    public NotFoundException(String message, Integer code) {
        super(message, code);
    }
}
