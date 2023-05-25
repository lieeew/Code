package com.hspedu.Spring.AOP.aspectj;

import org.springframework.stereotype.Component;

/**
 * ClassName: Dog
 * Package: com.hspedu.Spring.AOP.proxy3
 *
 * @Author: leikooo
 * @Creat: 2023/5/25 - 6:55
 * @Description:
 */
@Component  // 使用@Component 当spring容器启动时, 将Dog注入到容器
public class Dog implements SmartAnimal {
    @Override
    public int getSum(int value1, int value2) {
        int value = value1 + value2;
        System.out.println("方法内部打印结果 = " + value);
        return value;
    }

    @Override
    public int getSub(int value1, int value2) {
        int value = value1 - value2;
        System.out.println("方法内部打印结果 = " + value);
        return value;
    }
}
