package com.hspedu.Spring.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLOutput;

/**
 * ClassName: VehicleProxyProvider
 * Package: com.hspedu.Spring.proxy2
 *
 * @Author: leikooo
 * @Creat: 2023/5/24 - 13:28
 * @Description:
 */
public class VehicleProxyProvider {
    // 定义一个属性
    // target_vehicle 表示真正要执行的对象
    // 该对象需要实现Vehicle接口
    private Vehicle targetVehicle;

    public VehicleProxyProvider(Vehicle targetVehicle) {
        this.targetVehicle = targetVehicle;
    }

    // 编写一个方法, 返回一个代理对象
    public Vehicle getProxy() {
        /*
            public static Object newProxyInstance(ClassLoader loader,
                                      Class<?>[] interfaces,
                                      InvocationHandler h)

                老师解读
                    1.  Proxy.newProxyInstance() 可以返回一个代理对象
                    2. ClassLoader loader 类的加载器
                    3. Class<?>[] interfaces 就是将来代理类的接口信息
                    4. InvocationHandler h 调用出库去/对象 , 有一个非常重要的方法

         */
        ClassLoader classLoader = targetVehicle.getClass().getClassLoader();

        // 拿到对象的接口信息, 底层是通过接口来调用
        Class<?>[] interfaces = targetVehicle.getClass().getInterfaces();

        /*
            InvocationHandler h 这个是一个接口, 不能直接对象, 所以需要 匿名内部类

            public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable;
         */
        InvocationHandler h = new InvocationHandler() {
            /**
             * invoke 方法是将来执行我们的 targetVehicle 的方法, 会调用
             * @param proxy 代表代理对象
             * @param method 就是通过代理对象调用方法  代理对象.run()
             * @param args 表示调用代理对象调用方法的xx参数  代理对象.run(xx)
             * @return 代理对象.run(xx) 返回的数据
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("交通工具开始运行了...");
                // 这里反射加动态代理
                Object invoke = method.invoke(targetVehicle, args);
                System.out.println("交通工具停止运行了...");
                return invoke;
            }
        };

        Object instance = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (Vehicle) instance;
    }


}
