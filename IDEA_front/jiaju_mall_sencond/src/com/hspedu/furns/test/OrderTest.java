package com.hspedu.furns.test;

import com.hspedu.furns.DAO.Impl.OrderDAOImpl;
import com.hspedu.furns.DAO.OrderDAO;
import com.hspedu.furns.entity.Order;
import org.junit.Test;

/**
 * ClassName: OrderTest
 * Package: com.hspedu.furns.test
 *
 * @Author: leikooo
 * @Creat: 2023/5/7 - 15:11
 * @Description:
 */
public class OrderTest {
    private final OrderDAO orderDAO = new OrderDAOImpl();
    @Test
    public void testOrder() throws Exception {
       // orderDAO.addOrder(new Order("3", new Date(), new BigDecimal(1), 0, 1));
        Order order = orderDAO.getOrder("1683537059020_5");
        System.out.println("order = " + order);
    }


    public static void main(String[] args) {

    }
}
