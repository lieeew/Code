package Day29;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/22 - 11 - 22
 * @Description: Day29
 */

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络编程
 *
 * 1. 如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 * 2. 找到主机后如何可靠高效地进行数据传输
 *
 * 解决办法:
 *  对应问题一: IP和 端口号
 *  对应问题二: 提供网络协议 TCP/IP参考模型
 *
 * 三 : 通信的要素一: IP和端口号
 * 1. ip: 唯一的标识Internet上的计算机(通信实体)
 * 2. 在Java中使用InetAddress类代表ip
 * 3. ip分类: IPV4和IPV6 ; 万维网和局域网
 * 4. 域名: www.baidu.com   www.google.com   www.mate.com   www.vip.com
 * 5. 本地回路地址  127.0.0.1 对应Localhost
 * 6. 两个常用方法:  如何实例化: getByName(String host) , getLocalHost()
 *    两个方法 :    getHostName() / getHostAddress()
 *
 * 7.端口号：正在计算机上运行的进程。
 * * 要求：不同的进程不同的端口号
 * * 范围：被规定为一个 16 位的整数 0~65535。
 *
 * 端口号与IP地址的组合得出一个网络套接字：Socket
 *
 */
public class IntAddressTest {

    @Test
    public void test1() {
        try {
            InetAddress inet1 = InetAddress.getByName("222.85.26.231");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
