package com.hspedu.Spring.homework.Test;

import com.hspedu.Spring.homework.Service.FinallyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: FinallyTest
 * Package: com.hspedu.Spring.homework.Test
 *
 * @Author: leikooo
 * @Creat: 2023/6/5 - 12:33
 * @Description:
 */
public class FinallyTest {
    @Test
    public void test1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("shoping_ioc.xml");
        FinallyService finallyService = ioc.getBean(FinallyService.class);
        finallyService.buyGood(1, 1,1, 1, 1);

    }

}
