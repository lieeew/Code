package com.hspedu.Spring.AOP.homework;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: HomeWorkTest
 * Package: com.hspedu.Spring.AOP.homework
 *
 * @Author: leikooo
 * @Creat: 2023/5/27 - 9:52
 * @Description:
 */
public class HomeWorkTest {

    @Test
    public void testHomeWork() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans11.xml");
        UsbInterface phone = ioc.getBean("phone", UsbInterface.class);
        phone.work();

        System.out.println("============");

        UsbInterface camera = ioc.getBean("camera", UsbInterface.class);
        camera.work();
    }
}
