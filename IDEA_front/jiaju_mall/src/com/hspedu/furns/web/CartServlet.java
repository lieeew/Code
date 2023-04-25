package com.hspedu.furns.web;

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.CartItem;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.utils.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/4/24
 * @Description:
 */

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先得到添加家居的信息
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        int count = DataUtils.parseInt(req.getParameter("count"), 1);

        Furn furnById = furnService.getFurnById(new Furn(id));
        if (furnById == null) {
            // 可以记录一下自己还需要写一些逻辑
            // todo
            return;
        }
        // 根据Furn构建 CartItems
        CartItem cartItem = new CartItem(
                furnById.getId(),
                furnById.getName(),
                furnById.getPrice(),
                count,
                furnById.getPrice().multiply(new BigDecimal(count)));
        // Cart cart = new Cart();
        // // 判断是否有session, 如果没有这个属性直接创建 我的写法
        // HttpSession session = req.getSession();
        // if (session.getAttribute("cart") == null) {
        //     cart.add(cartItem);
        //     session.setAttribute("cart", cart);
        // } else {
        //     // 修改属性就ok
        //     Cart session_cart = (Cart) session.getAttribute("cart");
        //     session_cart.add(cartItem);
        // }
        // System.out.println(session.getAttribute("cart"));

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            // 如果没有的画就创建一个在设置到session之中
            cart = new Cart(); // 这个是空的, 不要在添加数据, 不然就多了, 下面有一个添加数据的操作
            req.getSession().setAttribute("cart", cart);
        }
        cart.add(cartItem);
        // System.out.println(cart);

        // Referer: http://localhost:8888/jiaju_mall/ 就是请求的地址
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);

    }

    /**
     * 给前端界面发送指定的数据
     */
    protected void showItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null) {
            resp.sendRedirect(req.getContextPath() + "/views/cart/cart.jsp");
            return;
        }
        // ArrayList<CartItem> cartItems = cart.getCartValues();
        // req.setAttribute("cartValues", cartItems);
        req.setAttribute("cart", cart);
        req.getRequestDispatcher("/views/cart/cart.jsp").forward(req, resp);
    }

    /**
     * 清空所有的购物车信息
     */
    protected void clearAllItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clearAllCartItems();

        resp.sendRedirect(req.getContextPath() + "/views/cart/cart.jsp");
    }


    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("hello~~~");
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        int newNum = DataUtils.parseInt(req.getParameter("newNum"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.updateCount(cart.getItems().get(id), newNum);
        req.getSession().setAttribute("cart", cart);
        // System.out.println("id = " + id);
        // System.out.println("newNum = " + newNum);
        // System.out.println(cart);
        // req.getRequestDispatcher("/CartServlet?action=showItems").forward(req, resp);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 删除订单
     */
    protected void deleteCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.deleteCartItem(cart.getItems().get(id));
        req.getRequestDispatcher("/CartServlet?action=showItems").forward(req, resp);
    }
}
