package com.hspedu.furns.test;

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.Furn;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * ClassName: CartTest
 * Package: com.hspedu.furns.test
 *
 * @Author: leikooo
 * @Creat: 2023/5/7 - 7:06
 * @Description:
 */
public class CartTest {

    @Test
    public void testGetTotalCount() {
        Cart cart = new Cart();
        cart.addItem(new Furn(1, "", "", new BigDecimal(10), 1, 1, ""), 1);
        cart.addItem(new Furn(2, "", "", new BigDecimal(10), 1, 1, ""), 1);
        cart.addItem(new Furn(3, "", "", new BigDecimal(10), 1, 1, ""), 2);
        int totalCount = cart.getTotalCount();
        System.out.println(totalCount);
    }

    public static void main(String[] args) {
        // 不是我想写, 主要是不加的话是以tomcat启动的
    }
}
