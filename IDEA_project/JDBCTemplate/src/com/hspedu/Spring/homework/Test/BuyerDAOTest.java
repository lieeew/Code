package com.hspedu.Spring.homework.Test;

import com.hspedu.Spring.homework.DAO.BuyerDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: BuyerDAOTest
 * Package: com.hspedu.Spring.homework.Test
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 12:08
 * @Description:
 */
public class BuyerDAOTest {

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("shoping_ioc.xml");
        BuyerDAO buyerDAO = ioc.getBean(BuyerDAO.class);
        buyerDAO.update(1, 1, 1);
    }
}
