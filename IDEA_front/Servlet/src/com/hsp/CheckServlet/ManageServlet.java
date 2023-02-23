package com.hsp.CheckServlet;

/**
 * @Author: qxy
 * @Date: 2023/2/22
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/manageServlet")
public class ManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("manageServlet~~");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String role = (String) request.getAttribute("role");
        System.out.println("ManageRequest = " + request); // 同一个对象
        // 输出信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("username = " + username + "</br></br>");
        writer.print("role = " + role);
        writer.flush();
        writer.close();

    }
}
