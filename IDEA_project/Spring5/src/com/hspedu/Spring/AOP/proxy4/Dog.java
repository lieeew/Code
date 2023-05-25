package com.hspedu.Spring.AOP.proxy4;

/**
 * ClassName: Dog
 * Package: com.hspedu.Spring.AOP.proxy3
 *
 * @Author: leikooo
 * @Creat: 2023/5/25 - 6:55
 * @Description:
 */
public class Dog implements SmartAnimal {


    @Override
    public int getSum(int value1, int value2) {
//        System.out.println("日志-方法名-getSum-参数 " + value1 + " " + value2);
        int value = value1 + value2;
        System.out.println("方法内部打印结果 = " + value);
//        System.out.println("方法内部打印 result = " + value);
//        System.out.println("日志-方法名-getSum-结果 result= " + value);
        return value;
    }

    @Override
    public int getSub(int value1, int value2) {
//        System.out.println("日志-方法名-getSub-参数 " + value1 + " " + value2);
        int value = value1 - value2;
        System.out.println("方法内部打印结果 = " + value);
//        System.out.println("方法内部打印 result = " + value);
//        System.out.println("日志-方法名-getSub-结果 result= " + value);
        return value;
    }
}
