package qqService;

import qqcommen.Message;
import qqcommen.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/1/29 23
 * @Description: 该类和客户端某一个线程保持通信
 */
public class serverConnectClientThread extends Thread {
    private Socket socket;
    private String userId; // 链接到服务器的id, 区分用户

    public serverConnectClientThread() {
    }

    public serverConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("客户单和服务器保持通信, 读取数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject(); // 没有消息就会阻塞在这里

                if (message.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    // 如果请求这个的话
                    System.out.println(message.getSender() + "要查看用户列表");
                    message.setMessageType(MessageType.MESSAGE_RED_ONLINE_FRIEND);
                    message.setGetter(message.getSender()); // 设置接收者, 就是发送者
                    String str = ManageServerConnectClient.getOnlineThread();
                    message.setContent(str);
                    // 把message对象发送给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                } else {
                    System.out.println("其他的消息类型!");
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
