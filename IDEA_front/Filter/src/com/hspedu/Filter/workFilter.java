package com.hspedu.Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/3/25
 * @Description:
 */
public class workFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter()~~~~");
        String content = (String) servletRequest.getServletContext().getAttribute("content");
        System.out.println("content = " + content);
        if (content.contains("香蕉") || content.contains("苹果")) {
            servletRequest.getRequestDispatcher("/topic.jsp").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
