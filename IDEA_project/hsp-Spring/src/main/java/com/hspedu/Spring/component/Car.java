package com.hspedu.Spring.component;

import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.processor.InitializingBean;

/**
 * ClassName: Car
 * Package: com.hspedu.Spring.component
 *
 * @Author: leikooo
 * @Creat: 2023/5/31 - 14:31
 * @Description:
 */
@Component
public class Car implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car 的初始化方法~~");
    }
}
