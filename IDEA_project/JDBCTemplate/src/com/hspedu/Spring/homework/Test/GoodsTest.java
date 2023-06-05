package com.hspedu.Spring.homework.Test;

import com.hspedu.Spring.homework.DAO.GoodsDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: OrderTest
 * Package: com.hspedu.Spring.homework.Test
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 11:16
 * @Description:
 */
public class GoodsTest {

    @Test
    public void testOrder(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("shoping_ioc.xml");
        GoodsDAO bean = ioc.getBean(GoodsDAO.class);
        double price = bean.queryPriceForId(1);
        System.out.println("price = " + price);

    }

    @Test
    public void testOrder2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("shoping_ioc.xml");
        GoodsDAO bean = ioc.getBean(GoodsDAO.class);
        bean.update(1, 2);

    }
}
