package com.hspedu.furns.test;

import com.hspedu.furns.DAO.OrderDAO;
import com.hspedu.furns.DAO.OrderItemDAO;
import com.hspedu.furns.DAO.impl.OrderDAOImpl;
import com.hspedu.furns.DAO.impl.OrderItemDAOImpl;
import com.hspedu.furns.entity.OrderItem;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: qxy
 * @Date: 2023/4/29
 * @Description:
 */
public class OrderItemsDAOTEST {
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Test
    public void testOrderItems() throws Exception {
        int totalCount = orderItemDAO.getTotalCount("16827336052518");
        System.out.println("totalCount = " + totalCount);
        int totalCountPrice = orderItemDAO.getTotalCountPrice("16827336052518");
        System.out.println("totalCountPrice = " + totalCountPrice);

    }

    @Test
    public void test() throws Exception {
        ArrayList<OrderItem> orderItems = orderItemDAO.getOrderItems("16827336052518");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }

    }
}
