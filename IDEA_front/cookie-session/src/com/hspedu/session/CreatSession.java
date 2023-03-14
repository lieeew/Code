package com.hspedu.session;

/**
 * @Author: qxy
 * @Date: 2023/3/13
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreatSession", urlPatterns = "/CreatSession")
public class CreatSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CreatSession 被调用~~~~");

        // 1. 获取session或者是创建session

        // JSESSIONID=C8C0316C92440A40CE5E306B2F62660D
        HttpSession session = request.getSession();
        // 2. 给session获取id
        String id = session.getId();
        System.out.println("id = " + id);
        // 3. 放入数据
        session.setAttribute("email", "zs@gmail.com");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>session ~~~~~<h1>");
        writer.flush();
        writer.close();

    }
}
