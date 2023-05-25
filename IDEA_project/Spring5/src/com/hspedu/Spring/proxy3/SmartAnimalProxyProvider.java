package com.hspedu.Spring.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: SmartAnimalProxyProvider
 * Package: com.hspedu.Spring.proxy3
 *
 * @Author: leikooo
 * @Creat: 2023/5/25 - 9:32
 * @Description:
 */
public class SmartAnimalProxyProvider {
    private SmartAnimal smartAnimal;

    public SmartAnimalProxyProvider(SmartAnimal smartAnimal) {
        this.smartAnimal = smartAnimal;
    }

    // 获取代理对象
    public SmartAnimal getProxy() {
        ClassLoader classLoader = smartAnimal.getClass().getClassLoader();

        Class<?>[] interfaces = smartAnimal.getClass().getInterfaces();

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("日志-方法名-" + method.getName() + "-参数 " + args[0] + " , " + args[1]);
                Object result = null;
                try {
                    result = method.invoke(smartAnimal, args);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("日志-方法名-" + method.getName() + "-结果 result= " + result);
                }
                return result;
            }
        };
        Object instance = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (SmartAnimal) instance;

    }
}
