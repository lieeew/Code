package com.hspedu.servlet;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OkServlet", urlPatterns = "/OK")
public class OkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 老韩多锁一句, 为了不破坏快捷键要选择leave
        System.out.println("OkServlet被调用~~");
    }
}
