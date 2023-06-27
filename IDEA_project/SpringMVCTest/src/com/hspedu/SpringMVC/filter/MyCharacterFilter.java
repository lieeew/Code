package com.hspedu.SpringMVC.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author leikooo
 * @create 2023-06-26 16:43
 * @Package com.hspedu.SpringMVC.filter
 * @Description
 */
public class MyCharacterFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 设置编码格式，解决中文乱码问题
        servletRequest.setCharacterEncoding("utf-8");
        // 需要放行
        filterChain.doFilter(servletRequest,servletResponse);


    }

    @Override
    public void destroy() {

    }
}
