package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/28
 * @Description:
 */

import com.hspedu.furns.DAO.OrderItemDAO;
import com.hspedu.furns.DAO.impl.OrderItemDAOImpl;
import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.entity.OrderItem;
import com.hspedu.furns.service.OrderService;
import com.hspedu.furns.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends BasicServlet {
    private OrderService orderService = new OrderServiceImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    /**
     * 生成订单
     */
    protected void saveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 业务代码
        // todo
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getItems().size() == 0) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return; // 返回
        }
        if (member == null) {
            response.sendRedirect(request.getContextPath() + "/views/member/login.jsp");
            return;
        }
        String orderId = orderService.saveOrder(cart, member.getId());
        session.setAttribute("orderId", orderId);
        // 便于前端读取数据
        int totalCount = orderItemDAO.getTotalCount(orderId);
        int totalCountPrice = orderItemDAO.getTotalCountPrice(orderId);
        ArrayList<OrderItem> orderItems = orderItemDAO.getOrderItems(orderId);
        session.setAttribute("orderItems", orderItems);
        session.setAttribute("totalCount", totalCount);
        session.setAttribute("totalPrice", totalCountPrice);
        // 使用重定向找到 checkout.jsp
        response.sendRedirect(request.getContextPath() + "/views/order/checkout.jsp");

    }
}
