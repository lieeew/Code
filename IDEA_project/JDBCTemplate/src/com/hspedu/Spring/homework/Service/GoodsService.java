package com.hspedu.Spring.homework.Service;

import com.hspedu.Spring.homework.DAO.GoodsDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: GoodsService
 * Package: com.hspedu.Spring.homework.Service
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 12:18
 * @Description:
 */
@Service
public class GoodsService {
    @Resource
    private GoodsDAO goodsDAO;

    @Transactional
    public void changeGoods(int orderId, int amount) {
        goodsDAO.update(orderId, amount);
    }

}
