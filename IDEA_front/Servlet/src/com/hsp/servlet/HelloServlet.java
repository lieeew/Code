package com.hsp.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/2/17
 * @Description:
 */
public class HelloServlet implements Servlet {

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
        System.out.println("hi HelloServer~~~"); //必须重新发布
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

    }
}
