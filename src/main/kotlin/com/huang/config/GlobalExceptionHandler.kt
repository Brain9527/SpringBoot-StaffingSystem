package com.huang.config

import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException
import javax.validation.ValidationException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBindException(ex: ValidationException): String? {
        return ex.message
    }

    @ExceptionHandler(value = [BindException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBindException(ex: BindException): String {
        val error = if (ex.allErrors.count() > 0) ex.allErrors[0] else null
        return if (error is FieldError) {
            "${error.field}: ${error.defaultMessage}"
        } else {
            error.toString()
        }
    }
}