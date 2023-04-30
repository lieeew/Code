package com.hspedu.furns.Filter;

/**
 * @Author: qxy
 * @Date: 2023/4/29
 * @Description: 这个用于权限验证 如果没有没有登录就回到登录页面
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AuthFilter implements Filter {

    private List<String> excludeUrls = new ArrayList<String>();

    public void init(FilterConfig config) throws ServletException {
        String strExcludeUser = config.getInitParameter("excludeUrls");
        String[] splitUrl = strExcludeUser.split(",");
        excludeUrls = Arrays.asList(splitUrl);
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        Object member =  hsr.getSession().getAttribute("member");
        String url = hsr.getServletPath();
        if (!excludeUrls.contains(url)) { // 如果不包含对应的, 白名单
            if (member == null) {
                // 请求转发不走过滤器, 重定向走过滤器
                request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
                // ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/views/member/login.jsp");
                return; // 返回
            }
        }
        // 继续访问
        chain.doFilter(request, response);
    }
}
