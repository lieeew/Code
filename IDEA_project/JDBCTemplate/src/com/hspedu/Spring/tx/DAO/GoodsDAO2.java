package com.hspedu.Spring.tx.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * ClassName: GoodsService2
 * Package: com.hspedu.Spring.tx.DAO
 *
 * @Author: leikooo
 * @Creat: 2023/6/4 - 16:57
 * @Description:
 */
@Repository
public class GoodsDAO2 {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 返回对应id的价格
     * @param id
     * @return
     */
    public Float queryPriceById2(Integer id) {
        String sql = "SELECT price From spring.goods Where goods_id = ?";
        Float price = jdbcTemplate.queryForObject(sql, Float.class, id);
        return price;
    }

    /**
     * 修改用户的余额
     * @param user_id
     * @param money
     */
    public void updateBalance2(Integer user_id, Float money) {
        String sql = "UPDATEX spring.user_account SET money = money - ? Where user_id = ?";
        jdbcTemplate.update(sql, money, user_id);
    }

    /**
     * 修改商品地库存
     * @param goods_id
     * @param amount
     */
    public void updateAmount2(Integer goods_id, int amount){
        String sql = "UPDATE spring.goods_amount SET goods_num = goods_num - ? Where goods_id = ?";
        jdbcTemplate.update(sql, amount , goods_id);
    }


}
