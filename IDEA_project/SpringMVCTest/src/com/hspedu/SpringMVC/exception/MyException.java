package com.hspedu.SpringMVC.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author leikooo
 * @create 2023-06-29 17:17
 * @Package com.hspedu.SpringMVC.exception
 * @Description
 */
@Controller
public class MyException {
    @ExceptionHandler({ArithmeticException.class})
    public String myException(Exception ex, HttpServletRequest request) {
        request.setAttribute("ex", ex);
        System.out.println("自定义的异常是 " + ex);
        return "error";
    }

    @RequestMapping("/testException01")
    public String test01(Integer num) {
        int i = 1 / num;
        return "success";
    }

    @RequestMapping("/testException02")
    public String test02() {
        String str = "null";
        str.charAt(100);
        return "success";
    }

    @RequestMapping("/testException03")
    public String test03() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.xx.xxx");
        return "success";
    }
}
