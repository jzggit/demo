package com.jiang.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(HttpServletRequest request, HttpServletResponse resp, Exception e) {
        log.info("进入异常处理，{},{}",request.getRequestURI(),resp.getStatus());
        //是否属于自定义异常
        if(e instanceof BaseException){
            BaseException e1 = (BaseException) e;
            return Result.fail(e1.getCode(), e1.getMessage());
        }else{
            return Result.fail(ErrorType.SYSTEM_ERROR, request.getRequestURI(),e.getMessage());
        }
    }
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result nullExceptionHandle(HttpServletRequest request, HttpServletResponse resp, Exception e) {
        log.info("进入异常处理，{},{}",request.getRequestURI(),resp.getStatus());
        //是否属于自定义异常
        if(e instanceof NullPointerException){
            BaseException e1 = (BaseException) e;
            return Result.fail(e1.getCode(), e1.getMessage());
        }else{
            return Result.fail(ErrorType.SYSTEM_ERROR, request.getRequestURI(),e.getMessage());
        }
    }
}
