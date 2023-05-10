package com.hspedu.furns.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ClassName: AdminFilter
 * Package: com.hspedu.furns.filter
 *
 * @Author: leikooo
 * @Creat: 2023/5/9 - 6:08
 * @Description:
 */
public class AdminFilter implements Filter {
    private String filterName = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String adminFilter = filterConfig.getInitParameter("AdminFilter");
        filterName = adminFilter;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!servletRequest.getServletContext().equals(filterName)) {
            // 过滤对象
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            Object admin = req.getSession().getAttribute("admin");
            if (admin == null) {
                // 没有登录, 直接返回登录页面
                servletRequest.getRequestDispatcher("/views/manage/manage_login.jsp").forward(servletRequest, servletResponse);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
