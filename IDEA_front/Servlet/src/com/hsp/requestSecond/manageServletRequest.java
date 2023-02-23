package com.hsp.requestSecond;

/**
 * @Author: qxy
 * @Date: 2023/2/23
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/manageServlet2")
public class manageServletRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String posts = (String) request.getAttribute("role");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("用户名 = " + username + "<br>");
        writer.println("职位 = " + posts);
        writer.flush();
        writer.close();
    }
}
