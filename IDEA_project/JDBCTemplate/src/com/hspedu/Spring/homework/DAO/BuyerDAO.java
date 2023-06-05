package com.hspedu.Spring.homework.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: BuyerDAO
 * Package: com.hspedu.Spring.homework.DAO
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 11:02
 * @Description:
 */
@Repository
public class BuyerDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private GoodsDAO orderDAO;
    /**
     * 更新buyer表
     *
     * @param orderId 商品id
     * @param id      买家id
     * @param amount  购买数量
     */

    public void update(int orderId, int id, int amount) {
        double price = orderDAO.queryPriceForId(orderId);
        double money = queryPriceForId(id);
        String sql = "update spring.buyer set money = ?, good_id = ? where id = ?";
        jdbcTemplate.update(sql, money - price * amount, orderId, id);
    }

    /**
     * 查询某一个购买者的余额
     * @param orderId 商品id
     */

    public double queryPriceForId(@NonNull int orderId) {
        String sql = "select money from spring.buyer where id = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, orderId);
    }
}
