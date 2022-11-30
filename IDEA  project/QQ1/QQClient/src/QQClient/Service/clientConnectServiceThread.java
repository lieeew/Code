package QQClient.Service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/27 - 11 - 27
 * @Description: QQClient.Service
 */
public class clientConnectServiceThread extends Thread{
    private Socket socket;
    // 构造器接收socket的对象
    public clientConnectServiceThread(Socket socket) {
        this.socket = socket;

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 因为Thread在后台和服务保持通信, 因此我们用while循环
        while (true) {
            try {
                System.out.println("客户端线程, 等待服务器端发送的数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果服务器没有发送信息那么会一直在这里
                // 判断这个Message的类型
                Message mes = (Message) ois.readObject();
                // 如果读取到的在线服务列表
                if (MessageType.MESSAGE_RED_ONLINE_FRIEND.equals(mes.getMessageType())) {
                    // 取出在线列表并显示
                    String[] s = mes.getContent().split(" ");
                    System.out.println("\n=====当前在线列表=====");
                    for (String str : s) {
                        System.out.println("用户: " + str);
                    }
                } else if (MessageType.MESSAGE_COME_MES.equals(mes.getMessageType())) {
                    String content = mes.getContent();
                    String sender = mes.getSender();
                    String getter = mes.getGetter();
                    System.out.println(sender + "对" + getter + "说: " + content);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
