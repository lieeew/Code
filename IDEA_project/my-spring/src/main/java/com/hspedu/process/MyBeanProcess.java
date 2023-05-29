package com.hspedu.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyBeanProcess
 * Package: com.hspedu.process
 *
 * @Author: leikooo
 * @Creat: 2023/5/28 - 17:17
 * @Description:
 */
//@Component // 可以在这里实现后置处理器, 需要xml注意扫描的路径是什么
public class MyBeanProcess implements BeanPostProcessor {

    /**
     * 初始化之后调用的方法
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization 被调用" + beanName +" bean="+ bean.getClass());
        return bean;
    }

    /**
     * 初始化之前调用的方法
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization 被调用" + beanName+"bean= " + bean.getClass());
        return bean;
    }
}
