package Day29;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/23 - 11 - 23
 * @Description: Day29
 */
public class USDTest {

    // 发送端
    @Test
    public void test1() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
            String str = "我是UDP方式发射的导弹";
            byte[] bytes = str.getBytes();
            InetAddress localHost = InetAddress.getLocalHost();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, localHost, 8282); // 这个是数据包

            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            datagramSocket.close();
        }
    }


    // 接收端
    @Test
    public void test2() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(8282);

            byte[] buffer = new byte[100];
            DatagramPacket datagramPacket = new DatagramPacket(buffer,0,buffer.length);

            datagramSocket.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            datagramSocket.close();
        }
    }
}
