package com.hspedu.Spring.AOP.homework02;

import org.springframework.stereotype.Component;

/**
 * ClassName: MyCal
 * Package: com.hspedu.Spring.AOP.homework02
 *
 * @Author: leikooo
 * @Creat: 2023/5/28 - 10:16
 * @Description:
 */
//@Component
public class MyCal implements Cal{
    @Override
    public int cal1(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println("方法内部打印结果是 " + sum);
        return sum;
    }

    @Override
    public int cal2(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        System.out.println("方法内部打印结果是 " + sum);
        return sum;
    }
}
