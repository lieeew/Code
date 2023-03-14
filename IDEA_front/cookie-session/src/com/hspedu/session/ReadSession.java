package com.hspedu.session;

/**
 * @Author: qxy
 * @Date: 2023/3/14
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReadSession", urlPatterns = "/ReadSession")
public class ReadSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReadSession ~~~~~");

        // 1. 获取session, 如果没有session就会创建
        HttpSession session = request.getSession();
        System.out.println();
        System.out.println("session数据 = " + session.getId());
        // 2. 读取属性
        Object email = session.getAttribute("email");

        if (email != null) {
            System.out.println("session的属性 email = " + (String) email);
        } else {
            System.out.println("没有找到该session数据 ~~");
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>读取成功~~<h1>");
        writer.flush();
        writer.close();
    }
}
