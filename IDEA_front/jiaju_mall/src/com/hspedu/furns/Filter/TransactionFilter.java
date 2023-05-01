package com.hspedu.furns.Filter;

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.utils.JDBCUtilsByDruid;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/5/1
 * @Description: 管理事务的filter
 */
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            // 放行
            filterChain.doFilter(servletRequest, servletResponse);
            JDBCUtilsByDruid.commit(); // 同一提交事务
        } catch (Exception e) {
            // 这里会有一个小bug, 因为BasicServlet中捕获了异常, 导致这里不会有异常了
            // 这里的机制就是 如果try{}中又异常, 那么回执行catch{}中的语句
            // 解决方法 : 在BasicServlet时抛出异常
            // 异常之中可以处理业务逻辑的
            JDBCUtilsByDruid.rollBack(); // 出现异常, 就回滚
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/views/order/checkout.jsp");
            ((Cart)((HttpServletRequest) servletRequest)
                    .getSession()
                    .getAttribute("cart"))
                    .clearAllCartItems();
            // 抛出去给到tomcat
            throw new RuntimeException(e);
            // e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
