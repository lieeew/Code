package QQClient.server;

import qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/30 - 11 - 30
 * @Description: QQClient.server
 */
public class ClientConnectServerThread extends Thread{
    // 该线程需要持有socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为Thread需要在后台和服务器通信，因此我们while循环
        while (true) {
            System.out.println("客户端线程等待读取服务端发送的消息");
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                // 如果服务器没有发送Message对象
                Message o = (Message) objectInputStream.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
