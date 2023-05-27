package com.hspedu.Spring.AOP.homework;

import org.springframework.stereotype.Component;

/**
 * ClassName: Car
 * Package: com.hspedu.Spring.AOP.homework
 *
 * @Author: leikooo
 * @Creat: 2023/5/27 - 12:01
 * @Description:
 */
@Component // 把Car视为一个组件, 注入到容器之中
public class Car {
    public void run() {
        System.out.println("小汽车在running~~");
    }
}
