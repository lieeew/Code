package com.hspedu.Spring;

import com.hspedu.Spring.component.MonsterService;
import com.hspedu.Spring.component.SmartAnimal;
import com.hspedu.Spring.ioc.HspSpringApplicationContext;
import com.hspedu.Spring.ioc.HspSpringConfig;
import org.junit.Test;

import javax.xml.bind.annotation.XmlAnyAttribute;

/**
 * ClassName: AppMain
 * Package: com.hspedu.Spring
 *
 * @Author: leikooo
 * @Creat: 2023/5/29 - 16:48
 * @Description:
 */
public class AppMain {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        HspSpringApplicationContext ioc = new HspSpringApplicationContext(HspSpringConfig.class);
//        Object monsterDAO1 = ioc.getBean("monsterDAO");
//        Object monsterDAO2 = ioc.getBean("monsterDAO");
//        System.out.println("monsterDAO1 = " + monsterDAO1);
//        System.out.println("monsterDAO2 = " + monsterDAO2);
//
//        Object monsterService1 = ioc.getBean("monsterService");
//        Object monsterService2 = ioc.getBean("monsterService");
//        System.out.println("monsterService1 = " + monsterService1);
//        System.out.println("monsterService2 = " + monsterService2);

//        MonsterService monsterService1 = (MonsterService) ioc.getBean("monsterService");
//        monsterService1.hello();

        SmartAnimal bean = (SmartAnimal) ioc.getBean("smartDog");
        // class com.sun.proxy.$Proxy4
        System.out.println(bean.getClass());
        bean.getSum(12, 30);
    }

    @Test
    public void test1() {

    }

}
