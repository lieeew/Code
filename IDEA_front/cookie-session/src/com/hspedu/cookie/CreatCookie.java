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

@WebServlet(name = "CreatCookie", urlPatterns = "/CreatCookie")
public class CreatCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CreatCookie 被调用 !!!");
        // 1. 创建一个cookie对象
        // 1) 改cookie的名字就是唯一的, 不能重复
        // 2) 可以创建多个cookie对象
        // 3) 这是cookie在服务器端, 还没有到浏览器
        Cookie cookie = new Cookie("username", "hsp");
        response.addCookie(cookie);
        Cookie cookie1 = new Cookie("pwd", "hspEdu");
        response.addCookie(cookie1);
        response.setContentType("text/html;charset=utf-8");
        // 2. 将改cookie发送给浏览器, 让浏览器保存该cookie
        PrintWriter writer = response.getWriter();
        writer.println("<h1>创建改cookie对象~~</h1>");
        writer.flush();
        writer.close();
    }
}
