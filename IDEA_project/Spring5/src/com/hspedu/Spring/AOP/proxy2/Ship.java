package com.hspedu.Spring.AOP.proxy2;

/**
 * ClassName: Ship
 * Package: com.hspedu.Spring.AOP.proxy2
 *
 * @Author: leikooo
 * @Creat: 2023/5/24 - 10:22
 * @Description:
 */
public class Ship implements Vehicle{

    @Override
    public void run() {
//        System.out.println("交通工具开始运行了...");
        System.out.println("大轮船在水上 running...");
//        System.out.println("交通工具停止运行了...");
    }

    @Override
    public String fly(int height) {
        System.out.println("轮船在天上飞 = " + height);
        return "轮船在天上飞 = " + height;
    }

}
