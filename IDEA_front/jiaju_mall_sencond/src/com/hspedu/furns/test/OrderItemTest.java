package com.hspedu.furns.test;

import com.hspedu.furns.DAO.Impl.OrderItemDAOImpl;
import com.hspedu.furns.DAO.OrderItemDAO;
import com.hspedu.furns.entity.OrderItem;
import org.junit.Test;

import java.util.ArrayList;

/**
 * ClassName: OrderItemTest
 * Package: com.hspedu.furns.test
 *
 * @Author: leikooo
 * @Creat: 2023/5/7 - 21:59
 * @Description:
 */
public class OrderItemTest {
    private final OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    @Test
    public void test() {
//        int totalCount = orderItemDAO.getTotalCount("1683467149378_5");
//        System.out.println("totalCount = " + totalCount);
        ArrayList<OrderItem> orderItems = orderItemDAO.getOrderItems("1683535184658_5");
        System.out.println(orderItems);

    }

    public static void main(String[] args) {

    }
}
