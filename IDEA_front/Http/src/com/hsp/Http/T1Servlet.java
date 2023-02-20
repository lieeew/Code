package com.hsp.Http;

/**
 * @Author: qxy
 * @Date: 2023/2/20
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login2")
public class T1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 如果有请求那么重定向
        /*
        (1) 返回302状态码
        (2) 响应头中会有一个是 Location
         */
        response.sendRedirect("/Http/h1.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
