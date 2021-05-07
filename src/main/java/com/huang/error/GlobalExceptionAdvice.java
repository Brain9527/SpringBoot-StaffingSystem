package com.huang.error;

import com.huang.utils.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handleHttpException(HttpServletRequest req, Exception ex) {
        System.out.println("发生了异常");
        return "发生了异常";
    }

    @ExceptionHandler(value = HttpException.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result<Object> handleHttpException(HttpException ex, HttpServletResponse response) {
        System.out.println("抛出异常");
        System.out.println("发生了 HttpException");
        long timestamp = new Date().getTime();
        response.setStatus(ex.getHttpStatusCode());
        return new Result<>(ex.getCode(), "服务器异常，请稍后重试", timestamp, null);
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result<List<String>> bindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(o -> o.getDefaultMessage())
                .collect(Collectors.toList());
        return Result.fail(500, "参数校验失败", collect);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result<List<String>> bindExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> collect = constraintViolations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return Result.fail(500, "参数校验失败", collect);
    }
}
