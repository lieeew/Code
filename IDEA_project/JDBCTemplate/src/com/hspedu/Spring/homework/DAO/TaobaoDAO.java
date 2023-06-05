package com.hspedu.Spring.homework.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: TaobaoDAO
 * Package: com.hspedu.Spring.homework.DAO
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 11:46
 * @Description:
 */
@Repository
public class TaobaoDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;


    /**
     * 更新淘宝的金额
     * @param id id
     * @param price 加入的金额
     */
    @Transactional
    public void update(int id, double price) {
        String sql = "update spring.taoBao set price = ? + taobao.price where id = ?";
        jdbcTemplate.update(sql, price, id);
    }

    /**
     * 查询某一个淘宝的总金额
     * @param orderId 商品id
     */

    public double queryPriceForId(@NonNull int orderId) {
        String sql = "select price from spring.taobao where id = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, orderId);
    }

}
