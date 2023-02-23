package com.hsp.HomeWork;

/**
 * @Author: qxy
 * @Date: 2023/2/23
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ComputerServlet", urlPatterns = "/computerServlet")
public class ComputerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // System.out.println("computerServlet ~~~~");
        // User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/110.0
        String UserAgent = request.getHeader("User-Agent");
        Pattern compile = Pattern.compile("\\((.*)\\)"); // 中间的括号表示分组
        Matcher matcher = compile.matcher(UserAgent);
        matcher.find();
        System.out.println(matcher.group(0)); // (Windows NT 10.0; Win64; x64; rv:109.0)
        System.out.println(matcher.group(1));// Windows NT 10.0; Win64; x64; rv:109.0 第一个分组
        System.out.println("系统类型 = " + matcher.group(1).split(";")[0]);
        System.out.println("系统位数 = " + matcher.group(1).split(";")[1].trim());
    }
}
