package com.hsp.servlet;

import com.hsp.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;

/**
 * @Author: qxy
 * @Date: 2023/2/24
 * @Description:
 */


public class CalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("你好~~~~");
        int num1 = WebUtils.parseInt(req.getParameter("num1"), 0);
        int num2 = WebUtils.parseInt(req.getParameter("num2"), 0);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>" + num1 + " + " + num2 + " = " + (num1 + num2) + "</h1>");
        writer.flush();
        writer.close();
    }
}
