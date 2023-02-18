package com.hsp.servlet;

/**
 * @Author: qxy
 * @Date: 2023/2/18
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OkServlet doGet() ~~~");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OkServlet doPost() ~~~");
    }
}
