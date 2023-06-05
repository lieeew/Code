package com.hspedu.Spring.homework.Test;

import com.hspedu.Spring.homework.DAO.SellerDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: SellerDAOTest
 * Package: com.hspedu.Spring.homework.Test
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 12:11
 * @Description:
 */
public class SellerDAOTest {

    @Test
    public void testSave(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("shoping_ioc.xml");
        SellerDAO sellerDAO = ioc.getBean(SellerDAO.class);
        sellerDAO.update(1, 10);
    }
}
