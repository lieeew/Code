package com.hspedu.cookie;

/**
 * @Author: qxy
 * @Date: 2023/3/12
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(name = "ReadServlet", urlPatterns = "/ReadServlet")
public class ReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtils.readCookieByName("company", cookies);

        String value = cookie.getValue();
        System.out.println("value = " + value);

        String decode = URLDecoder.decode(value, "UTF-8");
        System.out.println("decode = " + decode);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>解码后的内容 " + decode + "<h1>");
        writer.flush();
        writer.close();

    }
}
