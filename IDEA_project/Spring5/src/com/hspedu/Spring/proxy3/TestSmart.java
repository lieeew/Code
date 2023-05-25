package com.hspedu.Spring.proxy3;

import org.junit.Test;

/**
 * ClassName: TestSmart
 * Package: com.hspedu.Spring.proxy3
 *
 * @Author: leikooo
 * @Creat: 2023/5/25 - 6:58
 * @Description:
 */
public class TestSmart {
    @Test
    public void testSmart() {
        SmartAnimal smartAnimal = new Dog();
        smartAnimal.getSub(1, 2);
        System.out.println("========");
        smartAnimal.getSum(1, 2);
    }

    @Test
    public void testSmart2() {
        SmartAnimal smartAnimal = new Dog();
        SmartAnimalProxyProvider smartAnimalProxyProvider = new SmartAnimalProxyProvider(smartAnimal);
        SmartAnimal proxy = smartAnimalProxyProvider.getProxy();
        int sub = proxy.getSub(5, 2);

        System.out.println("============");

        int sum = proxy.getSum(9, 2);
    }
}
