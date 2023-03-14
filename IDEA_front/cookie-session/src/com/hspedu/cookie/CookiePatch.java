package com.hspedu.cookie;

/**
 * @Author: qxy
 * @Date: 2023/3/11
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookiePatch", urlPatterns = "/CookiePatch")
public class CookiePatch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CookiePatch 路径~~~~");

        Cookie cookie1 = new Cookie("name", "liHua");
        Cookie cookie2 = new Cookie("email", "qq@gmail.com");
        // 设置不同的路径
        System.out.println("request.getContextPath() = " + request.getContextPath()); // /cs
        cookie1.setPath(request.getContextPath());
        cookie2.setPath(request.getContextPath() + "/aaa");
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>修改cookie路径成功!!!<h1>");
        writer.flush();
        writer.close();

    }
}
