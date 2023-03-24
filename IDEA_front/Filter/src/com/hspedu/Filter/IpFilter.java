package com.hspedu.Filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/3/24
 * @Description:
 */
public class IpFilter implements Filter {

    private String ip;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ip = filterConfig.getInitParameter("ip");
        System.out.println("ip = " + ip);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("IpFilter doFilter()~~~");
        String remoteAddr = servletRequest.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr);
        Pattern pattern = Pattern.compile("^" + ip.substring(0, 3) + "\\." + ip.substring(4) + "\\.\\d+\\.\\d+$");
        Matcher matcher = pattern.matcher(remoteAddr);
        if (matcher.find()) {
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("拦截成功~~");
            // 返回登录页面
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return; // 推出
        }

        // 没有拦截继续
        System.out.println("没有拦截~~~");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("IpFilter destroy()~~~");
    }
}
