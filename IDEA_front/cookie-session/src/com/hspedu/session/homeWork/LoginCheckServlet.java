package com.hspedu.session.homeWork;

/**
 * @Author: qxy
 * @Date: 2023/3/14
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginCheckServlet", urlPatterns = "/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginCheckServlet ~~~~");
        HttpSession session = request.getSession();
        session.setAttribute("pwd", request.getParameter("pwd"));

        request.getRequestDispatcher("/CheckServlet").forward(request, response);
    }
}
