package com.hspedu.Spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * ClassName: MyBeanPostProcessor
 * Package: com.hspedu.Spring.bean
 *
 * @Author: leikooo
 * @Creat: 2023/5/20 - 16:39
 * @Description: 这是一个后置处理器, 需要实现 BeanPostProcessor
 */
public class MyBeanPostProcessor implements BeanPostProcessor {


    /**
     * 在bean的init方法调用前执行
     * @param bean 就是 ioc 容器返回的 bean 对象, 如果这里被替换会修改，则返回的 bean 对象也会被修改
     * @param beanName 就是 ioc 容器配置的 bean 的名称
     * @return 程序员对传入的bean记性返回/修改, 返回的 bean 对象
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization()~~" + "bean = "
                + bean + " beanName = " + beanName);
        return bean;
    }

    /**
     * 在bean的init方法调用后执行
     * @param bean 就是 ioc 容器返回的 bean 对象, 如果这里被替换会修改，则返回的 bean 对象也会被修改
     * @param beanName 就是 ioc 容器配置的 bean 的名称
     * @return 就是返回的 bean 对象
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization()~~");
        return bean;
    }
}
