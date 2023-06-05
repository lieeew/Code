package com.hspedu.Spring.homework.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: GoodsDAO
 * Package: com.hspedu.Spring.homework.DAO
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 11:11
 * @Description:
 */
@Repository
public class GoodsDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询某一个商品地单价
     * @param orderId 商品id
     */

    public double queryPriceForId(@NonNull int orderId) {
        String sql = "select price from spring.homework_goods where id = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, orderId);
    }

    /**
     * 修改goods表的存量
     * @param orderId 购买的商品id
     * @param amount 购买的数量
     */

    public void update(@NonNull int orderId, int amount) {
        String sql = "update spring.homework_goods set allowance = ? where id = ?";
        Integer preAllowance = jdbcTemplate.queryForObject("select allowance from spring.homework_goods where id = ?", int.class, orderId);
        if (preAllowance < amount) {
            return;
        }
        int infected = jdbcTemplate.update(sql, preAllowance - amount, orderId);
    }

}
