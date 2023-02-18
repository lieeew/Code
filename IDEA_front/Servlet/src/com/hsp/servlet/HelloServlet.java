package com.hsp.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/2/17
 * @Description:
 */
public class HelloServlet implements Servlet {
    private int count = 0; // 这里可以验证Tomcat所持有的HashMap是唯一的

    /**
     * 1. 初始化servlet
     * 2. 创建HelloServlet实例时, 会调用init方法
     * 3. 该方法只会被调用一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init被调用");
    }

    /**
     * @return 返回servlet对象
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 1. 处理浏览器的请求(包括get/post)
     * 2. 当浏览器每一次请求servlet时, 就会调用一次servlet
     * 3. 当Tomcat调用这个方法时, 会发http请求封装成实现了ServletRequest接口的对象
     * 4. 通过这个对象, 可以得到用户提交的数据
     * 5. servletResponse 可以用于返回数据給Tomcat, 之后变成http响应給浏览器
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hi HelloServer~~~ count = " + count++); //必须重新发布
        // Tomcat每处理一次http请求就会, 开启一个新的线程
        System.out.println("线程的Id = " + Thread.currentThread().getId());

        //思考->从 servletRequest 对象来获取请求方式->
        //1. ServletRequest 没有得到提交方式的方法
        //2. ServletRequest 看看 ServletRequest 子接口有没有相关方法
        //3. 老师小技巧：ctrl+alt+b => 可以看到接口的子接口和实现子类
        //4. 把 servletRequest 转成 HttpServletRequest 引用
        //5. 仍然是 Java 基础的 OO
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if ("POST".equals(httpServletRequest.getMethod())) {
            doPost();
        } else if ("GET".equals(httpServletRequest.getMethod())) {
            doGet();
        }
    }

    /**
     * 用于响应请求
     */
    public void doGet() {
        System.out.println("doGet() 被调用");
    }

    /**
     * 用于响应请求
     */
    public void doPost() {
        System.out.println("doPost() 被调用");
    }

    /**
     * 返回servlet对象的一些信息
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 用来销毁servlet实例
     */
    @Override
    public void destroy() {
        System.out.println(" destroy() 被调用~~~");
    }


}
