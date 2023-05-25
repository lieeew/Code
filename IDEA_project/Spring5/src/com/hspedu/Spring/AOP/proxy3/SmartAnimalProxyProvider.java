package com.hspedu.Spring.AOP.proxy3;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * ClassName: SmartAnimalProxyProvider
 * Package: com.hspedu.Spring.AOP.proxy3
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
        // 得到类的加载器
        ClassLoader classLoader = smartAnimal.getClass().getClassLoader();
        // 得到对象的接口信息
        Class<?>[] interfaces = smartAnimal.getClass().getInterfaces();
        // 匿名内部类
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    //  从AOP来看, 这个也是一个横切关注点
                    System.out.println("方法执行前 - 日志-方法名-" + method.getName() + "-参数 " + Arrays.asList(args));
                    result = method.invoke(smartAnimal, args);
                    System.out.println("方法执行正常结束 - 日志-方法名-" + method.getName() + "-结果 result= " + result);
                    return result;
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                    // 如果出现异常就会进入到catch {}
                    //  从AOP来看, 这个也是一个横切关注点
                    System.out.println("方法执行异常结束 !!! --" + method.getName() + "--" + e.getClass().getName());
                } finally {
                    // 不管有没有异常, 都会执行
                    //  从AOP来看, 这个也是一个横切关注点, 最终通知
                    System.out.println("方法执行结束 -- 日志 -- 方法" + method.getName());
                }
                return result;
            }
        };
        Object instance = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (SmartAnimal) instance;

    }
}
