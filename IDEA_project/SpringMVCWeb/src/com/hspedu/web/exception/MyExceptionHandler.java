package com.hspedu.web.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author leikooo
 * @create 2023-06-28 21:31
 * @Package com.hspedu.web.exce ption
 * @Description
 */
@Controller
public class MyExceptionHandler {

    /**
     * 1. 这个方法是处理局部异常
     * 2. 这里处理的是 ArithmeticException.class, NullPointerException.class 这两个异常
     * 3. Exception ex 生成的异常对象，可以通过 ex 获取相关的信息，可以加入自己的逻辑
     */
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String localException(HttpServletRequest request, Exception ex) {
        System.out.println("局部异常对象 = " + ex);
        request.setAttribute("erro", ex);
        return "exception_mine";
    }

    /**
     * 如果我们不进行异常处理，那么 Tomcat 就会默认处理
     */
    @RequestMapping("/testException01")
    public String test01(Integer num) {
        int i = 1 / num;
        return "success";
    }

    @RequestMapping("/testGlobalException")
    public String global() {
        // 局部异常没有这个异常，去找全局异常
        int num = Integer.parseInt("hello");
        return "success";
    }

    @RequestMapping("/testException02")
    public String test02() {
        throw new AgeException("年龄需要在 1 - 120 之间~~~");
    }

    @RequestMapping("/testException03")
    public String test03() {
        int[] arr = new int[10];
        System.out.println("arr[90] = " + arr[90]);
        return "success";
    }

    @RequestMapping("/testException04")
    public String test04() {
        String hello = "hello";
        // 这里会抛出 StringIndexOutOfBoundsException
        char c = hello.charAt(100);
        return "success";
    }

}
