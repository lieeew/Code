package com.hspedu.furns.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: qxy
 * @Date: 2023/4/14
 * @Description:
 */
public abstract class BasicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BasicServlet ~~");
        String action = req.getParameter("action");
        // System.out.println("action = " + action);

        // 如何调用这个方法 login 或者 register 这个方法
        try {
            Class<?> memberServlet = Class.forName("com.hspedu.furns.web.memberServlet");
            Object o = memberServlet.newInstance();
            memberServlet.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class).invoke(o, req, resp);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
