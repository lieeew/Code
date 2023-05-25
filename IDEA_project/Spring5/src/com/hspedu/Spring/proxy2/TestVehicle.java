package com.hspedu.Spring.proxy2;

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
        // 当执行到对应方法时会执行到代理对象的invoke
        Vehicle proxy = vehicleProxyProvider.getProxy();

        System.out.println("运行类型是 : " + proxy.getClass());
        // 这个动态体现在很多不同的方面 1.对象 2. 方法
        String fly = proxy.fly(100);
        System.out.println("fly = " + fly);
    }

    @Test
    public void proxyRun2() throws Exception {
        Vehicle vehicle = new Car();
        VehicleProxyProvider2 vehicleProxyProvider2 = new VehicleProxyProvider2(vehicle);
        Vehicle proxy = vehicleProxyProvider2.getProxy();
        String fly = proxy.fly(200);
        System.out.println("fly = " + fly);
    }

    @Test
    public void proxyRun3() throws Exception {
        Vehicle vehicle = new Ship();
        VehicleProxyProvider3 vehicleProxyProvider3 = new VehicleProxyProvider3(vehicle);
        // Vehicle 运行类型是
        Vehicle targetVehicle = vehicleProxyProvider3.getTargetVehicle();
        String fly = targetVehicle.fly(200);
        System.out.println("fly = " + fly);
    }

}
