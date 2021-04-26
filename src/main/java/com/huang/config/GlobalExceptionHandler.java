package com.huang.config;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBindException(ValidationException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBindException(BindException ex) {
        ObjectError error = ex.getAllErrors().get(0);
        if (error instanceof FieldError) {
            FieldError fieldError = (FieldError) error;
            return fieldError.getField() + ": " + fieldError.getDefaultMessage();
        } else {
            return error.toString();
        }
    }
}
