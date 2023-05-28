package com.hspedu.Spring.AOP.xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

/**
 * ClassName: AspectTest
 * Package: com.hspedu.Spring.AOP.xml
 *
 * @Author: leikooo
 * @Creat: 2023/5/28 - 8:20
 * @Description:
 */
public class AspectTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans12.xml");
        SmartAnimal smartAnimal = ioc.getBean(SmartAnimal.class);
        smartAnimal.getSum(1, 2);

    }

}
