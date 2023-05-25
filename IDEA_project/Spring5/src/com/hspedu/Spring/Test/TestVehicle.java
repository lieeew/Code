package com.hspedu.Spring.Test;

import com.hspedu.Spring.AOP.proxy2.Car;
import com.hspedu.Spring.AOP.proxy2.Vehicle;
import com.hspedu.Spring.AOP.proxy2.VehicleProxyProvider;
import org.junit.Test;

/**
 * ClassName: TestVehicl
 * Package: com.hspedu.Spring.Test
 *
 * @Author: leikooo
 * @Creat: 2023/5/24 - 13:55
 * @Description:
 */
public class TestVehicle {

    @Test
    public void proxyRun() throws Exception {
        Vehicle ship = new Car();
        // 创建了 vehicleProxyProvider 并且传入了要代理的对象 ship
        VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(ship);

        // 获取代理对象
        // 该对象可以代理执行方法
        // 编译类型是 Vehicle
        // 运行类型是 代理类型 class com.sun.proxy.$Proxy4
        // 当执行到run方法时会执行到代理对象的invoke
        Vehicle proxy = vehicleProxyProvider.getProxy();

        System.out.println("运行类型是 : " + proxy.getClass());
        // 这个动态体现在很多不同的方面 1.对象 2. 方法
        proxy.run();
    }
}
