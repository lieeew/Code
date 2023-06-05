package com.hspedu.Spring.homework.Test;

import com.hspedu.Spring.homework.DAO.TaobaoDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TaobaoTest
 * Package: com.hspedu.Spring.homework.Test
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 12:12
 * @Description:
 */
public class TaobaoTest {

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("shoping_ioc.xml");
        TaobaoDAO bean = ioc.getBean(TaobaoDAO.class);
        bean.update(1, 10);

    }
}
