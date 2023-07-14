package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author leikooo
 * @create 2023-07-14 18:00
 * @Package PACKAGE_NAME
 * @Description
 */
public class RentProxy implements InvocationHandler {

    private Rent rent;

    public RentProxy(Rent rent) {
        this.rent = rent;
    }

    public Rent getProxy() {
        return (Rent) Proxy.newProxyInstance(rent.getClass().getClassLoader(), rent.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("hello");
        return method.invoke(proxy, args);
    }
}
