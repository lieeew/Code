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
 * @Creat: 2023/6/2 - 17:49
 * @Description:
 */
@Component
public class HspBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println(bean + "的后置通知 postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println(bean + "的后置通知 postProcessAfterInitialization");
        // 这里AOP机制
        if (bean instanceof SmartAnimal) {
            // 如果实现了 接口
            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            Object obj = null;
                            if ("getSum".equals(method.getName())) {
                                SmartAnimalAspect.beforeLog();
                                obj = method.invoke(bean, args);
                                SmartAnimalAspect.afterLog();
                            } else {
                                obj = method.invoke(bean, args);
                            }
                            return obj;
                        }
                    }
            );
        }
        return bean;
    }
}
