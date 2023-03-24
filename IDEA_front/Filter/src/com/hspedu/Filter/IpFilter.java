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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String remoteAddr = servletRequest.getRemoteAddr();
        Pattern pattern = Pattern.compile("128.12.\\d+.\\d+");
        Matcher matcher = pattern.matcher(remoteAddr);
        if (matcher.find()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("拦截成功~~~");
        }

    }

    @Override
    public void destroy() {

    }
}
