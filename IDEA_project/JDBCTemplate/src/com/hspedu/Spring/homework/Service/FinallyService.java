package com.hspedu.Spring.homework.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: FinallyService
 * Package: com.hspedu.Spring.homework.Service
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 12:24
 * @Description:
 */
@Service
public class FinallyService {
    @Resource
    private BuyerService buyerService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private SellerService sellerService;
    @Resource
    private TaobaoService taobaoService;

    @Transactional
    public void buyGood (int goodsId, int sellerId, int taobaoId, int amount, int buyerId) {

        buyerService.buyGoods(goodsId, buyerId, amount);

        goodsService.changeGoods(goodsId, amount);

        sellerService.sellerGoods(goodsId, sellerId, amount);

        taobaoService.addTaobaoMoney(taobaoId, goodsId, amount);

    }

}
