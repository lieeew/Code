package com.hspedu.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author leikooo
 * @create 2023-06-29 6:44
 * @Package com.hspedu.web.exception
 * @Description @ControllerAdvice  如果在类上面标识，就是一个全局异常处理类
 */
@ControllerAdvice
public class MyGlobalException {

    /**
     * 1. 全局异常就是不管是哪一个 handler 抛出的异常，都可以捕获 @ExceptionHandler({异常类型})
     * 2. 全局异常优先级低
     */
    @ExceptionHandler({NumberFormatException.class, ClassCastException.class, AgeException.class})
    public String globalException(Exception ex, HttpServletRequest request) {
        System.out.println(" 全局异常信息 ex = " + ex);
        request.setAttribute("erro", ex);
        return "exception_mine";
    }

}
