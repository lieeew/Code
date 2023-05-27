package com.hspedu.Spring.AOP.homework;

import org.springframework.stereotype.Component;

/**
 * ClassName: Phone
 * Package: com.hspedu.Spring.AOP.homework
 *
 * @Author: leikooo
 * @Creat: 2023/5/26 - 14:52
 * @Description:
 */
@Component(value = "phone") // 将component注入到容器之中
public class Phone implements UsbInterface{
    @Override
    public int work() {
        System.out.println("打电话 + 发送数据~~");
        return 0;
    }
}
