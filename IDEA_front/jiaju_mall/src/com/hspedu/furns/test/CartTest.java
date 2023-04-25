package com.hspedu.furns.test;

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author: qxy
 * @Date: 2023/4/24
 * @Description:
 */
public class CartTest {

    @Test
    public void test1() throws Exception {
        Cart cart = new Cart();
        cart.add(new CartItem(1, "桌子", new BigDecimal(100), 1, new BigDecimal(100)));
        // cart.add(new CartItem(2, "椅子", new BigDecimal(100), 1, new BigDecimal(100)));
        cart.add(new CartItem(1, "桌子", new BigDecimal(100), 1, new BigDecimal(100)));
        cart.add(new CartItem(1, "桌子", new BigDecimal(100), 1, new BigDecimal(100)));
        cart.add(new CartItem(1, "桌子", new BigDecimal(100), 1, new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void test2() throws Exception {
        Cart cart = new Cart();
        cart.add(new CartItem(1, "桌子", new BigDecimal(100), 1, new BigDecimal(100)));
        // cart.add(new CartItem(2, "椅子", new BigDecimal(100), 1, new BigDecimal(100)));
        cart.add(new CartItem(1, "桌子", new BigDecimal(100), 1, new BigDecimal(100)));
        cart.add(new CartItem(1, "桌子", new BigDecimal(100), 1, new BigDecimal(100)));
        cart.add(new CartItem(1, "桌子", new BigDecimal(100), 1, new BigDecimal(100)));
        BigDecimal totalPrice = cart.getTotalPrice();
        System.out.println(totalPrice);
    }
}
