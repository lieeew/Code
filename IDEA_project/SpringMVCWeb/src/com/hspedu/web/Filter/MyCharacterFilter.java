package com.hspedu.web.Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author leikooo
 * @create 2023-06-24 16:50
 * @Package com.hspedu.web.Filter
 * @Description Filter 这个是 javax 下面的 servlet
 */
public class MyCharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 加入对编码的处理
        servletRequest.setCharacterEncoding("utf-8");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
