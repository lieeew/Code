package com.hspedu.Spring.AOP.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: VehicleProxyProvider4
 * Package: com.hspedu.Spring.AOP.proxy2
 *
 * @Author: leikooo
 * @Creat: 2023/5/25 - 6:10
 * @Description:
 */
public class VehicleProxyProvider4 {
    private Vehicle targetVehicle;

    public VehicleProxyProvider4(Vehicle targetVehicle) {
        this.targetVehicle = targetVehicle;
    }

    public Vehicle getTargetVehicle() {
        ClassLoader classLoader = targetVehicle.getClass().getClassLoader();
        // 接口信息
        Class<?>[] interfaces = targetVehicle.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("轮船开始运行~");
                Object invoke = method.invoke(targetVehicle, args);
                System.out.println("轮船结束运行~");
                return invoke;
            }
        };
        Object instance = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (Vehicle) instance;
    }
}
