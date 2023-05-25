package com.hspedu.Spring.AOP.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: VehicleProxyProvider3
 * Package: com.hspedu.Spring.AOP.proxy2
 *
 * @Author: leikooo
 * @Creat: 2023/5/24 - 20:59
 * @Description:
 */
public class VehicleProxyProvider3 {
    private Vehicle targetVehicle;

    public VehicleProxyProvider3(Vehicle targetVehicle) {
        this.targetVehicle = targetVehicle;
    }

    public Vehicle getTargetVehicle() {
        ClassLoader classLoader = targetVehicle.getClass().getClassLoader();

        Class<?>[] interfaces = targetVehicle.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("交通工具开始运行了...");
                Object invoke = method.invoke(targetVehicle, args);
                System.out.println("交通工具停止运行了...");
                return invoke;
            }
        };
        Object result = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (Vehicle) result;
    }
}
