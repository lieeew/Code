package com.hspedu.furns.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: qxy
 * @Date: 2023/4/14
 * @Description:
 */
public abstract class BasicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这里设置彻底可以解决中文乱码问题
        req.setCharacterEncoding("UTF-8");
        // 一定要把action 要满 足action的值和方法名保持一致, 要不然反射会失败
        String action = req.getParameter("action");
        // System.out.println("action = " + action);

        // 如何调用这个方法 login 或者 register 这个方法
        try {
            // 1. 这个时候的this就是 请求的Servlet对象
            // 在Java中，this是一个关键字，它代表当前类的实例对象。在上述代码中，this代表的是当前请求的Servlet对象，也就是BasicServlet的一个实例。
            // 因为该方法是被BasicServlet继承自HttpServlet的，所以this代表的就是BasicServlet的对象。
            // 使用this关键字可以访问当前对象的属性和方法，也可以用来引用当前对象。
            // 2. declareMethod 方法就是当前请求的servlet对应的action名字的方法 是变化的
            // 使用了 模板模式 + 反射 + 动态机制
            Method declareMethod = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // System.out.println(declareMethod);
            // System.out.println(this.getClass());
            // 使用方法对象, 直接反射调用
            declareMethod.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
