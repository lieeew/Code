package com.hspedu.Spring.tx.Service;

import com.hspedu.Spring.tx.DAO.GoodsDAO;
import com.hspedu.Spring.tx.DAO.GoodsDAO2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: GoodsService
 * Package: com.hspedu.Spring.tx.Service
 *
 * @Author: leikooo
 * @Creat: 2023/6/4 - 8:13
 * @Description: 会使用到事务
 */
@Service
public class GoodsService {

    //需要一個属性
    @Resource
    private GoodsDAO goodsDAO;

    @Resource
    private GoodsDAO2 goodsDAO2;
    /**
     * 购买商品
     *
     * @param userId  用户id
     * @param goodsId 商品id
     * @param amount  购买的数量
     */
    public void bugGoods(int userId, int goodsId, int amount) {
        System.out.println("用户 user = " + userId + " 商品id = " + goodsId + " 数量 = " + amount);

        // 1. 得到商品地价格
        Float price = goodsDAO.queryPriceById(userId);
        // 2.减少商品地数量
        goodsDAO.updateAmount(goodsId, amount);
        // 3. 减少用户的余额
        goodsDAO.updateBalance(userId, price * amount);

        System.out.println("购买成功");
    }

    /**
     * 购买商品
     * 1. 使用 @Transactional 可以进行声明式事务控制
     * 2. @Transactional 将表示地方法对数据库的操作作为一个事务管理
     * 3. 底层使用的是AOP机制
     * 4. 底层是动态代理调用 bugGoodsByTx() 方法
     * 5. 执行 bugGoodsByTx()方法, 先调用事务管理器的 doBegin() , 之后调用 bugGoodsByTx()
     * 如果执行正常声明式事务的 doCommit() , 否自执行 doRollback()
     *
     * @param userId  用户id
     * @param goodsId 商品id
     * @param amount  购买的数量
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void bugGoodsByTx(int userId, int goodsId, int amount) {
        System.out.println("用户 user = " + userId + " 商品id = " + goodsId + " 数量 = " + amount);
        // 1. 得到商品的价格
        Float price = goodsDAO.queryPriceById(userId);
        // 2.减少商品的数量
        goodsDAO.updateAmount(goodsId, amount);
        // 3. 减少用户的余额
        goodsDAO.updateBalance(userId, price * amount);

        System.out.println("购买成功");
    }

    /**
     * 这个方法是第二套进行商品地第二套
     * @param userId
     * @param goodsId
     * @param amount
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void bugGoodsByTx2(int userId, int goodsId, int amount) {
        System.out.println("用户 user = " + userId + " 商品id = " + goodsId + " 数量 = " + amount);

        // 1. 得到商品的价格
        Float price = goodsDAO2.queryPriceById2(userId);
        // 2.减少商品的数量
        goodsDAO2.updateAmount2(goodsId, amount);
        // 3. 减少用户的余额
        goodsDAO2.updateBalance2(userId, price * amount);

        System.out.println("购买成功");
    }

    /**
     * READ_COMMITTED 表示读已提交
     * @param userId
     * @param goodsId
     * @param num
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void buyGoodsByTxISOLATION(int userId, int goodsId, int num) {
        Float price = goodsDAO.queryPriceById(userId);
        System.out.println("第一次读取的价格 = " + price);
        //测试一下隔离级别，在同一个事务中，查询一下价格
        price = goodsDAO.queryPriceById(goodsId);
        System.out.println("第二次读取的价格 = " + price);

    }

    /**
     * timeout = 2
     * 1. 如果执行时间超过2s, 那么事务就会回滚
     * 2. 默认的是 -1 , 表示使用的事务默认超时时间
     */
    @Transactional(timeout = 2)
    public void buyGoodsByTxTimeouts(int userId, int goodsId, int amount) {
        System.out.println("用户 user = " + userId + " 商品id = " + goodsId + " 数量 = " + amount);

        // 1. 得到商品的价格
        Float price = goodsDAO2.queryPriceById2(userId);
        // 2.减少商品的数量
        goodsDAO2.updateAmount2(goodsId, amount);
        try {
            // 模拟超时
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 3. 减少用户的余额
        goodsDAO2.updateBalance2(userId, price * amount);

        System.out.println("购买成功");

    }
 }
