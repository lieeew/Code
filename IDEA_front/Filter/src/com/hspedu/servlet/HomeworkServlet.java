package com.hspedu.servlet;

/**
 * @Author: qxy
 * @Date: 2023/3/25
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeworkServlet", urlPatterns = "/HomeworkServlet")
public class HomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HomeworkServlet ~~~~");
        String username = request.getParameter("username");
        String content = request.getParameter("content");

        System.out.println("username = " + username);
        System.out.println("content = " + content);

        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("content", content);
        servletContext.setAttribute("username", username);

        response.sendRedirect(request.getContextPath() + "/homework/showTopic.jsp");
    }
}
