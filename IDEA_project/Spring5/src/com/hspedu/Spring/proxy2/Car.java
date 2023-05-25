package com.hspedu.Spring.proxy2;

/**
 * ClassName: Car
 * Package: com.hspedu.Spring.proxy2
 *
 * @Author: leikooo
 * @Creat: 2023/5/24 - 10:21
 * @Description:
 */
public class Car implements Vehicle{
    @Override
    public void run() {
        System.out.println("交通工具开始运行了...");
        System.out.println("小汽车在公路 running..");
        System.out.println("交通工具停止运行了...");
    }

    @Override
    public String fly(int height) {
        System.out.println("小汽车飞行的高度 = " + height);
        return "小汽车可以飞翔的高度" + height;
    }
}
