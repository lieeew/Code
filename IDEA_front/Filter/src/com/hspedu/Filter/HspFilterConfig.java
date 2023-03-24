package com.hspedu.Filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author: qxy
 * @Date: 2023/3/23
 * @Description:
 */
public class HspFilterConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HspFilterConfig init() ~~~");
        String filterName = filterConfig.getFilterName();
        // 这个以后就可以和多个servlet配置
        ServletContext servletContext = filterConfig.getServletContext();
        // 这里可以获取到该类filter的所有参数信息
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        // 遍历
        while (initParameterNames.hasMoreElements()) {
            System.out.println("name = " + initParameterNames.nextElement());
        }
        System.out.println("filterName = " + filterName);
        System.out.println("servletContext = " + servletContext);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
