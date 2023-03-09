package com.hspedu.cookie;

/**
 * @Author: qxy
 * @Date: 2023/3/8
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 读取从浏览器发送的客户端[cookie信息 底层还是http请求]
 */
@WebServlet(name = "ReadCookies", urlPatterns = "/ReadCookies")
public class ReadCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReadCookies 被调用~~~");

        // 通过request对象找到所有的cookie信息
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                System.out.println("name = " + cookie.getName() + "\t" + "value = " + cookie.getValue());
            }
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>读取cookie成功~~~</h1>");
        writer.flush();
        writer.close();
    }
}
