package com.hspedu.furns.filter;

import com.google.gson.Gson;
import com.hspedu.furns.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: AuthServlet
 * Package: com.hspedu.furns.filter
 *
 * @Author: leikooo
 * @Creat: 2023/5/7 - 8:51
 * @Description:
 */
public class AuthServlet implements Filter {
    private List<String> url = new ArrayList<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String ignoreUrl = filterConfig.getInitParameter("IgnoreUrl");
        String[] split = ignoreUrl.split(",");
        // 放入到url集合
        url = Arrays.asList(split);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Object member = req.getSession().getAttribute("member");
        String servletPath = req.getServletPath();
       // System.out.println("contextPath = " + servletPath);
        if (!url.contains(servletPath)) {
            if (member == null) {
                if (WebUtils.isAjaxRequest(req)) {
                    // 是Ajax请求
                    // 按照json格式返回数据
                    HashMap<String, Object> urlMap = new HashMap<String, Object>();
                    urlMap.put("url", "views/member/login.jsp");
                    String urlJson = new Gson().toJson(urlMap);
                    resp.getWriter().write(urlJson);
                    return; // 返回
                } else {
                    // 不是Ajax请求
                    if (!url.contains(servletPath)) { // 如果不包含对应的, 白名单
                        // 请求转发不走过滤器, 重定向走过滤器
                        req.getRequestDispatcher("/views/member/login.jsp").forward(req, resp);
                        // ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/views/member/login.jsp");
                        return; // 返回
                    }
                }
            }
        }
        // 已经登录, 就放行
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
