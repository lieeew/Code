package com.hsp.servletReqyest;

/**
 * @Author: qxy
 * @Date: 2023/2/22
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.Principal;

@WebServlet(urlPatterns = "/requestMethods")
public class ServletRequestMethods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 请求头相关
        /*
        思考题: 如果发现一个ip在10s内访问次数大于100次, 就封掉这个ip

        1. 创建一个集合ConcurrentHshMap对应每一个ip访问的次数
        2. 开一个线程记录次数
        3. 进行比对, 如果符合条件就封掉这个ip
         */
        String method = request.getMethod(); // 提交方式
        String requestURI = request.getRequestURI(); // uri
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("请求客户端的ip地址 : " + request.getRemoteAddr());
        System.out.println("http请求头Host = " + request.getHeader("Host")); // getHeader很厉害
        System.out.println("该请求发起的地址是 = " + request.getHeader("Referer"));
        System.out.println("cookie = " + request.getHeader("Cookie"));
        String[] s = request.getHeader("User-Agent").split(" ");
        System.out.println("访问的浏览器是 = " + s[s.length - 1].split("\\/")[0]); // split支持正则表达式
        // 取出操作系统和操作位数
        // Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/110.0
        String regStr = request.getHeader("User-Agent").split("[(,)]")[1];
        System.out.println("系统版本 = " + regStr.split(";")[0]);
        // 操作位数
        System.out.println("系统版本位数 = " + regStr.split(";")[1]);
        System.out.println("method = " + method);
        System.out.println("requestURI = " + requestURI);
        System.out.println("requestURL = " + requestURL);

        // ************************
        // 请求体
        // 1. 获取表单的数据[单个数据]
        // username=%E9%9F%A9%E9%A1%BA%E5%B9%B3&pwd=121212&county=chongqing
        // 增强for快捷键 iter
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        System.out.println("username = " + username);
        System.out.println("pwd = " + pwd);
        String[] counties = request.getParameterValues("county");
        for (String county : counties) {
            System.out.println("county = " + county);
        }
        System.out.println("~~~~~~~~~~~~~~");
    }
}
