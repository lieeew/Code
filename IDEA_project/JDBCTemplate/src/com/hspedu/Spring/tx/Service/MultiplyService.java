package com.hspedu.Spring.tx.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: MultiplyService
 * Package: com.hspedu.Spring.tx.Service
 *
 * @Author: leikooo
 * @Creat: 2023/6/4 - 17:03
 * @Description:
 */
@Service
public class MultiplyService {

    @Resource
    private GoodsService goodsService;

    /**
     * 1. 这个方法有两次购买商品的操作
     * 2. bugGoodsByTx() 和 bugGoodsByTx2() 都是声明式事务
     * 3. 目前 bugGoodsByTx() 和 bugGoodsByTx2() 使用的传播机制是默认的 require (快捷键: ctrl + shift + u), 会当做整体事务对待
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void multiplyBuyGoods() {

        goodsService.bugGoodsByTx(1, 1, 1);

        goodsService.bugGoodsByTx2(1, 1, 1);
    }

}
