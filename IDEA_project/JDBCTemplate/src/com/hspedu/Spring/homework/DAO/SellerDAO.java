package com.hspedu.Spring.homework.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * ClassName: SellerDAO
 * Package: com.hspedu.Spring.homework.DAO
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 10:36
 * @Description:
 */
@Repository
public class SellerDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 更新卖家的账户金额
     * @param sellerId 卖家id
     * @param money 挣到的money
     */


    public void update(int sellerId, double money) {
        String sql = "update spring.seller set money = ? + seller.money where id =?";
        jdbcTemplate.update(sql, money, sellerId);
        System.out.println("卖家 " + sellerId + "赚到了 " + money);
    }

    /**
     * 查询某一个商品的单价
     * @param orderId 商品id
     */

    public double queryPriceForId(@NonNull int orderId) {
        String sql = "select money from spring.seller where id = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, orderId);
    }
}
