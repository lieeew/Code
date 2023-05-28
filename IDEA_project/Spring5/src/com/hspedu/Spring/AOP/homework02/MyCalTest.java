package com.hspedu.Spring.AOP.homework02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: MyCalTest
 * Package: com.hspedu.Spring.AOP.homework02
 *
 * @Author: leikooo
 * @Creat: 2023/5/28 - 10:21
 * @Description:
 */
public class MyCalTest {
    @Test
    public void test() {
        MyCal myCal = new MyCal();
        int i = myCal.cal1(100);
        int i1 = myCal.cal2(10);
        System.out.println("i = " + i);
        System.out.println("i1 = " + i1);

    }

    @Test
    public void test2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans13.xml");
        Cal bean = ioc.getBean(Cal.class);
        int i = bean.cal1(12);

        int i1 = bean.cal2(12);
    }

    @Test
    public void test3() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans13.xml");
        Cal bean = ioc.getBean(Cal.class);
        int i = bean.cal1(12);

        int i1 = bean.cal2(12);
    }
}
