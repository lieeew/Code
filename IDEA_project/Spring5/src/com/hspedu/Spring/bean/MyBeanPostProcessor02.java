package com.hspedu.Spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * ClassName: MyBeanPostProcessor02
 * Package: com.hspedu.Spring.bean
 *
 * @Author: leikooo
 * @Creat: 2023/5/21 - 17:35
 * @Description:
 */
public class MyBeanPostProcessor02 implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization 的 Bean " + bean + " beanName=" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization 的 Bean " + bean + " beanName=" + beanName);
        return bean;
    }
}
