package com.hspedu.Spring.processor;

/**
 * ClassName: BeanPostProcessor
 * Package: com.hspedu.Spring.processor
 *
 * @Author: leikooo
 * @Creat: 2023/5/30 - 21:34
 * @Description: 这两个方法会对spring容器的所有bean生效
 */
public interface BeanPostProcessor {

    /**
     * 该方法会在bean的初始化方法后调用
     * @param bean
     * @param beanName
     * @return
     */
    default Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }

    /**
     *  该方法在bean的初始化方法之前调用
     * @param bean
     * @param beanName
     * @return
     */
    default Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

}
