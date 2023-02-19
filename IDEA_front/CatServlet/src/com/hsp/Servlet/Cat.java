package com.hsp.Servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/2/18
 * @Description:
 */
public class Cat implements Servlet {
    private int num = 1;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServlet = (HttpServletRequest) servletRequest;
        System.out.println("第 " + num++ + "次访问");
        if ("POST".equals(httpServlet.getMethod())) {
            doPost();
        } else if ("GET".equals(httpServlet.getMethod())) {
            doGet();
        }
    }

    public void doGet() {
        System.out.println("doGet~~~");
    }
    public void doPost() {
        System.out.println("doPost~~~");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
