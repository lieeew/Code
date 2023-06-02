package com.hspedu.Spring;

import com.hspedu.Spring.component.MonsterService;
import com.hspedu.Spring.component.SmartAnimal;
import com.hspedu.Spring.ioc.HspSpringApplicationContext;
import com.hspedu.Spring.ioc.HspSpringConfig;

/**
 * ClassName: AppTest
 * Package: com.hspedu.Spring
 *
 * @Author: leikooo
 * @Creat: 2023/6/1 - 17:20
 * @Description:
 */
public class AppTest {
    public static void main(String[] args) {
        HspSpringApplicationContext ioc = new HspSpringApplicationContext(HspSpringConfig.class);
//        Object monsterDAO1 = ioc.getBean("monsterDAO");
//        Object monsterDAO2 = ioc.getBean("monsterDAO");
////
//        Object monsterService1 = ioc.getBean("monsterService");
//        Object monsterService2 = ioc.getBean("monsterService");
//
//        System.out.println("monsterDAO1 = " + monsterDAO1);
//        System.out.println("monsterDAO2 = " + monsterDAO2);
//        System.out.println("monsterService1 = " + monsterService1);
//        System.out.println("monsterService2 = " + monsterService2);
//        MonsterService monsterService1 = (MonsterService) ioc.getBean("monsterService");
//        monsterService1.hello();
//        SmartAnimal bean = (SmartAnimal) ioc.getBean("smartDog");
//        bean.getSum(9, 2);
//        bean.getSub(2, 3);
    }
}
