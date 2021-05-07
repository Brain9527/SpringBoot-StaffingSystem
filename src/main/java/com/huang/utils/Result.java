package com.huang.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private int code;
    private String message;
    private long time;
    private T data;

    public static <T> Result<T> fail(int code, String message, T data) {
        long timestamp = new Date().getTime();
        return new Result<>(code, message, timestamp, data);
    }
}
