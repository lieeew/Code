package com.hspedu.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/3/22
 * @Description:
 */

/*
    老韩解读
    1. filter在web启动时, 由tomcat来创建filter实例, 只会创建一个
        这个的意义是
        1.提高了应用程序的性能。因为Filter实例不需要在每个请求到达时都被创建，所以不需要进行额外的资源分配和垃圾回收。
        2.确保Filter的行为一致性。由于只有一个Filter实例存在，它们的行为将始终相同，无论请求来自于哪个客户端。
    2. 会调用filter的默认的无参构造器, 同时会调用init()方法, 只会调用一次init()方法
    3. 在创建filter实例时, 同时创建一个fileConfig对象相关的信息
    4. 当一个http请求, 和url-pattern相匹配时, 就会调用doFilter方法
    5. 在调用doFilter方法时, 就会同时创建  ServletRequest  ServletResponse  FilterChain 对象, 并通过doFilter传入
    6 .如果后面使用的资源(jsp, servlet ...) 会使用request 和 response. 那么就会继续传递
 */
public class ManageFilter implements Filter {

    private int count = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 当tomcat创建Filter就会调用该方法
        System.out.println("filter 的init() 方法被调用~~~");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 每次调用filter时, doFilter() 就会被调用
        System.out.println("filter doFilter 被调用~~~~");
        // 接口指向的是一个具体的对象, 后面还可以继续使用
        System.out.println("ManageFilter doFilter() 调用的次数 = " + (++count));
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();

        String parameter = servletRequest.getParameter("pwd");
        System.out.println("parameter = " + parameter);

        Object username = session.getAttribute("username");
        if (username == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        } else {
            // 如果不调用继续请求的方法, 那么就会卡住
            // 如果继续访问目标资源, 需要调用资源
            // 所以 : 我们这里就可以通过servletRequest 获取很多信息, 比如访问url, session
            // 比如访问的参数 ... 就可以做事务, 数据获取. 日志管理等

//            System.out.println("servletRequest = " + servletRequest);
//            System.out.println("====日志====");
//            System.out.println("访问的用户名 = " + username.toString());
//            System.out.println("用户ip = " + httpServletRequest.getRemoteAddr());
//            System.out.println("用户访问的资源地址 = " + httpServletRequest.getRequestURI());
            // 如果请求的资源不存在那么就会在这里报404的错误
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println(" filter 被destroy了~~~~");
    }
}
