package com.hspedu.furns.test;

import com.hspedu.furns.DAO.OrderDAO;
import com.hspedu.furns.DAO.OrderItemDAO;
import com.hspedu.furns.DAO.impl.OrderDAOImpl;
import com.hspedu.furns.DAO.impl.OrderItemDAOImpl;
import com.hspedu.furns.entity.Order;
import com.hspedu.furns.entity.OrderItem;
import com.hspedu.furns.entity.Status;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: qxy
 * @Date: 2023/4/27
 * @Description:
 */
public class OrderTest {
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Test
    public void test1() {
        int i = orderDAO.saveOrder(new Order("7", new Date(), new BigDecimal(1), Status.PREPARING_FOR_SHIPMENT, 1));
        if (i > 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    @Test
    public void test2() {
        orderItemDAO.saveOrderItem(new OrderItem(null, "12", new BigDecimal(12), 12, new BigDecimal(12), "112"));
    }
}
