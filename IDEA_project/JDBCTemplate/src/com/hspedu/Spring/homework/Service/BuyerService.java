package com.hspedu.Spring.homework.Service;

import com.hspedu.Spring.homework.DAO.BuyerDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: BuyerService
 * Package: com.hspedu.Spring.homework.Service
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 12:14
 * @Description:
 */
@Service
public class BuyerService {

    @Resource
    private BuyerDAO buyerDAO;

    /**
     * 购买商品
     * @param orderId 商品id
     * @param id 购买者id
     * @param amount 购买的数量
     */
    @Transactional
    public void buyGoods(int orderId, int id, int amount) {
        buyerDAO.update(orderId, id, amount);
    }

}
