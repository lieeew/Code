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

@WebServlet(name = "CreatCookie2", urlPatterns = "/CreatCookie2")
public class CreatCookie2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("username", "tom");
        Cookie email = new Cookie("email", "leikoo@qq.com");
        // response对象发送给到客户端
        response.addCookie(cookie);
        response.addCookie(email);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>写入到服务器~~~</h1>");
        writer.flush();
        writer.close();
    }
}
