package com.hspedu.servlet;

/**
 * @Author: qxy
 * @Date: 2023/3/16
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HiServlet", urlPatterns = "/HiServlet")
public class HiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HiServlet 被调用~~~~");

        PrintWriter writer = response.getWriter();
        response.sendRedirect("http://www.bing.com");

        request.getParameter("job");

        HttpSession session = request.getSession();
        session.setAttribute("job", "Java工程师");

        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("job", "php工程师");


    }
}
