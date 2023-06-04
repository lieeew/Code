package com.hspedu.Spring.tx;

import com.hspedu.Spring.tx.DAO.GoodsDAO;
import com.hspedu.Spring.tx.Service.GoodsService;
import com.hspedu.Spring.tx.Service.MultiplyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TxTest
 * Package: com.hspedu.Spring.tx
 *
 * @Author: leikooo
 * @Creat: 2023/6/4 - 7:56
 * @Description:
 */
public class TxTest {
    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsDAO goodsDAO = ioc.getBean(GoodsDAO.class);
        Float aFloat = goodsDAO.queryPriceById(1);
        System.out.println("aFloat = " + aFloat);

        // 测试第二个方法
        goodsDAO.updateAmount(1, 10);

        // 测试第三个方法
        goodsDAO.updateBalance(1, 10f);
    }

    @Test
    public void test2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);

        goodsService.bugGoods(1, 1, 2);


    }

    @Test
    public void test3() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);

        goodsService.bugGoodsByTx(1, 1, 2);

    }

    @Test
    public void multiplyBuyGoodsTest() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        MultiplyService goodsService = ioc.getBean(MultiplyService.class);
        goodsService.multiplyBuyGoods();
    }
}
