package com.hsp.HomeWork.response;

/**
 * @Author: qxy
 * @Date: 2023/2/23
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "PayServlet", urlPatterns = "/payServlet2")
public class PayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("pay success!");
        int money = WebUtils.transfer(request.getParameter("PaymentAmount"), response);
        String contextPath = getServletContext().getContextPath();
        if (money > 100) {
            // /Servlet
            response.sendRedirect(contextPath + "/paySuccess.html");
        } else {
            response.sendRedirect(contextPath + "/pay.html");
        }
    }
}
