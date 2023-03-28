package com.hspedu.Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/3/25
 * @Description:
 */
public class BFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long id = Thread.currentThread().getId();
        System.out.println("id = " + id);

        System.out.println("BFilter 前置代码");
        System.out.println("BFilter doFilter() ~~~");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("BFilter 后置代码~~~");
    }

    @Override
    public void destroy() {

    }
}
