package com.hspedu.furns.DAO.impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.OrderDAO;
import com.hspedu.furns.entity.Order;
import org.jetbrains.annotations.NotNull;

/**
 * @Author: qxy
 * @Date: 2023/4/26
 * @Description:
 */
public class OrderDAOImpl extends BasicDAO<Order> implements OrderDAO {


    @Override
    public int saveOrder(@NotNull Order order) {
        return update("INSERT INTO `order` (id, price, `status`, member_id) VALUES(?, ?, ?, ?)",
                order.getId(), order.getPrice(), order.getStatus(), order.getMemberId());
    }

}
