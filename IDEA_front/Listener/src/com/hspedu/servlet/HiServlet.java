package com.hspedu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/3/21
 * @Description:
 */
public class HiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HiServlet~~~~~");

        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("name", "韩顺平教育");
        servletContext.setAttribute("name", "hsp nb");
        servletContext.removeAttribute("name");

        HttpSession session = req.getSession();
        System.out.println("HiServlet创建完成 ~~~");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
