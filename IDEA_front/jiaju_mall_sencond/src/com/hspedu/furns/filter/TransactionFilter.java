package com.hspedu.furns.filter;

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.utils.JDBCUtilsByDruid;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: TransactionFilter
 * Package: com.hspedu.furns.filter
 *
 * @Author: leikooo
 * @Creat: 2023/5/8 - 13:55
 * @Description:
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            // 没出错直接提交
            JDBCUtilsByDruid.commit();
        } catch (Exception e) {
            System.out.println("报错了~~~");
            JDBCUtilsByDruid.rollBack();
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            Cart cart = (Cart) ((HttpServletRequest) servletRequest).getSession().getAttribute("cart");
            if (cart != null) {
                // cart不为null直接清空购物车
                cart = cart.clearAllItem(cart);
            }
            // 抛给tomcat
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
