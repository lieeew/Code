package com.hspedu.SpringMVC.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author leikooo
 * @create 2023-06-29 17:30
 * @Package com.hspedu.SpringMVC.exception
 * @Description
 */
@ControllerAdvice
public class MyGlobalException {

    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    public String globalException(Exception e, HttpServletRequest request) {
        request.setAttribute("ex", e);
        System.out.println("全局异常信息 " + e);
        return "error";
    }
}
