package com.hspedu.furns.Filter;

/**
 * @Author: qxy
 * @Date: 2023/5/3
 * @Description:
 */

import com.hspedu.furns.entity.Admin;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AdminFilter implements Filter {
    private List<String> excludeUrl = new ArrayList<String>();

    public void init(FilterConfig config) throws ServletException {
        String excludeUrls = config.getInitParameter("excludeUrls");
        excludeUrl.add(excludeUrls);
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        Admin admin = (Admin) hsr.getSession().getAttribute("admin");
        String url = hsr.getServletPath();
        if (admin == null) {
            if (!excludeUrl.contains(url)) {
                request.getRequestDispatcher("/views/manage/manage_login.jsp")
                        .forward(request, response);
                return; // 返回
            }
        }
        chain.doFilter(request, response);
    }
}
