package com.hspedu.Spring.component;

import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.processor.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: HspBeanPostProcessor
 * Package: com.hspedu.Spring.processor
 *
 * @Author: leikooo
 * @Creat: 2023/5/30 - 21:57
 * @Description: 1. 这个是我们的后置处理器
 * 2. 实现了 BeanPostProcessor
 * 3. 我们可以重写 before和 after 方法
 * 4. 加@Component注解 需要加载到容器之中, HspBeanPostProcessor需要加入到容器之中才能工作
 * 5. 需要考虑多个后置处理器
 */
@Component
public class HspBeanPostProcessor implements BeanPostProcessor {

    // 后置处理器是对容器之中创建的bean生效
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
//        if (bean instanceof Car) {
//            System.out.println("这个是一个car我要处理他~");
//        }

        if ("smartDog".equals(beanName)) {
            // 如果是这个类那么需要动态代理
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                Object proxyInstance = null;
                if ("getSum".equals(method.getName())) {
                    // 如果是这个方法那么就进行动态代理
                    proxyInstance = Proxy.newProxyInstance(HspBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            // 前置通知
                            SmartAnimalAspect.beforeLog();
                            Object result = method.invoke(bean, args);
                            // 后置通知
                            SmartAnimalAspect.afterLog();
                            return result;
                        }
                    });
                } else {
                    System.out.println("method " + method.getName() + "不需要动态代理~~");
                }
                return proxyInstance;
            }
            return bean;
        }

        System.out.println("postProcessAfterInitialization 被调用" + beanName + " bean=" + bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("postProcessBeforeInitialization 被调用" + beanName + "bean= " + bean.getClass());
        return bean;
    }
}
