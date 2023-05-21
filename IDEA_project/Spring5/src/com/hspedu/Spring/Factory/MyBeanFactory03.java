package com.hspedu.Spring.Factory;

import com.hspedu.Spring.bean.Monster;
import org.springframework.beans.factory.FactoryBean;

/**
 * ClassName: MyBeanFactory03
 * Package: com.hspedu.Spring.Factory
 *
 * @Author: leikooo
 * @Creat: 2023/5/21 - 16:01
 * @Description:
 */
public class MyBeanFactory03 implements FactoryBean<String> {

    @Override
    public String getObject() throws Exception {
        return "Hello, world!";
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

}
