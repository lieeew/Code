package com.hspedu.furns.DAO.Impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.OrderDAO;
import com.hspedu.furns.entity.Order;

/**
 * ClassName: OrderDAOImpl
 * Package: com.hspedu.furns.DAO.Impl
 *
 * @Author: leikooo
 * @Creat: 2023/5/7 - 14:58
 * @Description:
 */
public class OrderDAOImpl extends BasicDAO<Order> implements OrderDAO {

    @Override
    public int addOrder(Order order) {
        String sql = "INSERT INTO `order`(`id`, `create_time`, `price`, `status`, `member_id`) VALUES (?, ?, ?, ?, ?)";
        return update(sql, order.getId(), order.getCreatTime(), order.getPrice(), 0, order.getMemberId());
    }

    @Override
    public Order getOrder(String id) {
        String sql = "select `id`, `create_time` AS `creatTime`, `price`, `status`, `member_id` AS `memberId` from `order` where id = ?";
        return querySingle(sql, Order.class, id);
    }
}
