package com.hspedu.Spring.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * ClassName: VehicleProxyProvider2
 * Package: com.hspedu.Spring.proxy2
 *
 * @Author: leikooo
 * @Creat: 2023/5/24 - 17:56
 * @Description:
 */
public class VehicleProxyProvider2 {

    private Vehicle targetVehicle;

    public VehicleProxyProvider2(Vehicle targetVehicle) {
        this.targetVehicle = targetVehicle;
    }

    public Vehicle getProxy() {
        ClassLoader classLoader = targetVehicle.getClass().getClassLoader();

        Class<?>[] interfaces = targetVehicle.getClass().getInterfaces();

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("交通工具开始运行~");
                Object invoke = method.invoke(targetVehicle, args);
                System.out.println("交通工具结束运行~");
                return invoke;
            }
        };

        Object result = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (Vehicle) result;
    }
}
