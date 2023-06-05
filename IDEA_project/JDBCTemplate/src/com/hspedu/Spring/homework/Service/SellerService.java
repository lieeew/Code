package com.hspedu.Spring.homework.Service;

import com.hspedu.Spring.homework.DAO.GoodsDAO;
import com.hspedu.Spring.homework.DAO.SellerDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: SellerDAO
 * Package: com.hspedu.Spring.homework.Service
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 12:19
 * @Description:
 */
@Service
public class SellerService {

    @Resource
    private SellerDAO sellerDAO;
    @Resource
    private GoodsDAO goodsDAO;

    @Transactional
    public void sellerGoods(int goodsId, int sellerId, int amount) {
        sellerDAO.update(sellerId, goodsDAO.queryPriceForId(goodsId) * amount * 0.9);
    }

}
