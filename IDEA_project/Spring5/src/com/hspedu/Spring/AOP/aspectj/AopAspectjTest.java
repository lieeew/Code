package com.hspedu.Spring.AOP.aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: AopAspectjTest
 * Package: com.hspedu.Spring.AOP.aspectj
 *
 * @Author: leikooo
 * @Creat: 2023/5/25 - 17:24
 * @Description:
 */
public class AopAspectjTest {

    @Test
    public void test1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans10.xml");
        // 这里我们通过接口类型来获取注入到Dog对象
        SmartAnimal bean = ioc.getBean(SmartAnimal.class);
//        System.out.println(bean.getClass());
        int sum = bean.getSum(1, 2);
    }
}
