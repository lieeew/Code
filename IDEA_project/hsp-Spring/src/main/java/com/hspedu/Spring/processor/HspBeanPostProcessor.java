package com.hspedu.Spring.processor;

import com.hspedu.Spring.Annotation.Component;

/**
 * ClassName: HspBeanPostProcessor
 * Package: com.hspedu.Spring.processor
 *
 * @Author: leikooo
 * @Creat: 2023/5/30 - 21:57
 * @Description:
 * 1. 这个是我们的后置处理器
 * 2. 实现了 BeanPostProcessor
 * 3. 我们可以重写 before和 after 方法
 * 4. @Component 需要加载到容器之中
 */
@Component
public class HspBeanPostProcessor implements BeanPostProcessor{

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
