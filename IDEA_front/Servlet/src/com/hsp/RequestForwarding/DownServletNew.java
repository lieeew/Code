package com.hsp.RequestForwarding;

/**
 * @Author: qxy
 * @Date: 2023/2/23
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DownServletNew", urlPatterns = "/DownServletNew")
public class DownServletNew extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/x-tar;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("ok~~");
        writer.flush();
        writer.close();
    }
}
