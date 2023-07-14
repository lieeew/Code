package proxy;

import org.junit.Test;

/**
 * @author leikooo
 * @create 2023-07-14 18:02
 * @Package PACKAGE_NAME
 * @Description
 */
public class RentTest {
    @Test
    public void test() {
        RentProxy rentProxy = new RentProxy(new Buyer());
        Rent proxy = rentProxy.getProxy();
        proxy.buy();

    }
}
