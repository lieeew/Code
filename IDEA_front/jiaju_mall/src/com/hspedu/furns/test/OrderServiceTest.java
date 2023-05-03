package com.hspedu.furns.test;

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.CartItem;
import com.hspedu.furns.service.OrderService;
import com.hspedu.furns.service.impl.OrderServiceImpl;
import org.junit.Test;
import java.math.BigDecimal;

/**
 * @Author: qxy
 * @Date: 2023/4/28
 * @Description:
 */
public class OrderServiceTest {
    private OrderService orderService = new OrderServiceImpl();
    @Test
    public void testOrderService() {
        Cart cart = new Cart();
        // cart.add(new CartItem(1, "Sofa", new BigDecimal("100.00"), 2, new BigDecimal("200.00")));
        // cart.add(new CartItem(2, "Desk", new BigDecimal("200.00"), 2, new BigDecimal("400.00")));
        // orderService.saveOrder(cart, 1, new );
    }

    @Test
    public void test2() throws Exception {


    }

}
