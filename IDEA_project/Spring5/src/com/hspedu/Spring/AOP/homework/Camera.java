package com.hspedu.Spring.AOP.homework;

import org.springframework.stereotype.Component;

/**
 * ClassName: Camera
 * Package: com.hspedu.Spring.AOP.homework
 *
 * @Author: leikooo
 * @Creat: 2023/5/26 - 14:53
 * @Description:
 */
@Component
public class Camera implements UsbInterface{
    @Override
    public int work() {
        System.out.println("拍照片~");
        return 0;
    }
}
