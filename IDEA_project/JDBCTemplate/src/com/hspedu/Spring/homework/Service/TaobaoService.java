package com.hspedu.Spring.homework.Service;

import com.hspedu.Spring.homework.DAO.GoodsDAO;
import com.hspedu.Spring.homework.DAO.TaobaoDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: TaobaoService
 * Package: com.hspedu.Spring.homework.Service
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 12:22
 * @Description:
 */
@Service
public class TaobaoService {

    @Resource
    private TaobaoDAO taobaoDAO;

    @Resource
    private GoodsDAO goodsDAO;


    @Transactional
    public void addTaobaoMoney(int taobaoId, int orderId, int amount) {
        double price = goodsDAO.queryPriceForId(orderId);
        taobaoDAO.update(taobaoId, (price * amount) * 0.1);
    }
}
