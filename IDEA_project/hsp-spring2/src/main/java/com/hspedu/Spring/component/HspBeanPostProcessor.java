package com.hspedu.Spring.component;

import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.processor.BeanPostProcessor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: HspBeanPostProcessor
 * Package: com.hspedu.Spring.component
 *
 * @Author: leikooo
 * @Creat: 2023/6/2 - 6:46
 * @Description:
 */
@Component
public class HspBeanPostProcessor implements BeanPostProcessor {
    // 初始化方法有沒有都不會影響後置通知
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println(bean + "初始化方法的前置通知~~");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        // 我这里要进行AOP切面编程了
        // 假设知道切面类和需要代理的方法
        // 如果是SmartAnimal这个类的实现类
        if (bean instanceof SmartAnimal) {
            // 同时需要满足方法是sum()
            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            Object result = null;
                            if ("getSum".equals(method.getName())) {
                                SmartAnimalAspect.beforeLog();
                                result = method.invoke(bean, args);
                                SmartAnimalAspect.afterLog();
                            } else {
                                result = method.invoke(bean, args);
                            }
                            return result;
                        }
                    });
        }

        System.out.println(bean + "初始化方法的后置通知~");
        return bean;
    }
}
