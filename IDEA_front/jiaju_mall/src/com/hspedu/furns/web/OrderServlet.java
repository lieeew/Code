package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/28
 * @Description:
 */

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.OrderService;
import com.hspedu.furns.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends BasicServlet {
    private OrderService orderService = new OrderServiceImpl();
    /**
     * 生成订单
     */
    protected void saveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 业务代码
        // todo
        Member member = (Member) request.getSession().getAttribute("member");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null || cart.getItems().size() == 0) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return; // 返回
        }
        if (member == null) {
            response.sendRedirect(request.getContextPath() + "/views/member/login.jsp");
            return;
        }

        String orderId = orderService.saveOrder(cart, member.getId());
        request.getSession().setAttribute("orderId", orderId);
        // 使用重定向找到 checkout.jsp
        response.sendRedirect(request.getContextPath() + "/views/order/checkout.jsp");

    }
}
