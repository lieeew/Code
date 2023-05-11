package com.hspedu.furns.web;

import com.google.gson.Gson;
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
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/5/6
 * @Description:
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends BasicServlet {
    private final FurnService furnService = new FurnServiceImpl();

    protected void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("furnId"), 0);
        int count = DataUtils.parseInt(req.getParameter("count"), 1);
        // 需要被添加的商品
        Furn furnById = furnService.getFurnById(id);
        // 判断session里面有没有cart, 没有创建一个
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            // 设置到session里面
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(furnById, count);
        int totalCount = cart.getTotalCount();
        CartItem cartItem = new CartItem();
        cartItem.setCount(totalCount);
        String json = new Gson().toJson(cartItem);
        resp.getWriter().println(json);
    }


    /**
     * 更新购物车的数量
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int newNum = DataUtils.parseInt(req.getParameter("newNum"), 1);
        int cartId = DataUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart = cart.updateCount(cart, newNum, cartId);
        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void clearAllItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 把清空后的购物车赋值给session中的cart
        cart = cart.clearAllItem(cart);
        // 返回原来的页面
        resp.sendRedirect(req.getHeader("Referer"));

    }


    protected void delItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.getItems().remove(id);

        resp.sendRedirect(req.getContextPath() + "/views/cart/cart.jsp");
    }
}
