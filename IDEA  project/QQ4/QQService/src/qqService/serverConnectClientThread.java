package qqService;

import mysqlService.service.MessageService;
import qqcommen.Message;
import qqcommen.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/1/29 23
 * @Description: 该类和客户端某一个线程保持通信
 */
public class serverConnectClientThread extends Thread {
    private Socket socket;
    private String userId; // 链接到服务器的id, 区分用户
    private MessageService messageService = new MessageService();
    private OffLineService offLineService = new OffLineService();
    public serverConnectClientThread() {
    }

    public Socket getSocket() {
        return socket;
    }

    public serverConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("客户端 " + userId + " 和服务器保持通信, 读取数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject(); // 没有消息就会阻塞在这里

                if (message.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    // 如果请求这个的话
                    System.out.println(message.getSender() + " 要查看用户列表");
                    message.setMessageType(MessageType.MESSAGE_RED_ONLINE_FRIEND);
                    message.setGetter(message.getSender()); // 设置接收者, 就是发送者
                    String str = ManageServerConnectClient.getOnlineThread();
                    message.setContent(str);
                    // 把message对象发送给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                } else if (message.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXI)) {
                    String sender = message.getSender();
                    System.out.println(sender + " 请求退出 ");
                    // 把对应的socket关闭
                    ManageServerConnectClient.getThreadByUserId(sender).getSocket().close();
                    ManageServerConnectClient.remove(userId); // 从集合中删除
                    // 退出while循环
                    break;
                } else if (message.getMessageType().equals(MessageType.MESSAGE_COME_MES)) {
                   if (ManageServerConnectClient.isLive(message.getGetter())) {
                       // 这个message就是我需要的message
                       ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectClient.getThreadByUserId(message.getGetter()).socket.getOutputStream());
                       oos.writeObject(message);
                       // 保存导数据库
                       messageService.saveMessage(message.getSender(), message.getGetter(), message.getContent(), message.getMessageType());

                   } else {
                       // 不在线
                       offLineService.saveMessageForOffLine(message.getGetter(), message);
                   }
                } else if (message.getMessageType().equals(MessageType.SEND_MESSAGE_TO_ALL)) {
                    String onlineThread = ManageServerConnectClient.getOnlineThread();
                    String[] s = onlineThread.split(" ");
                    for (String s1 : s) {
                        ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectClient.getThreadByUserId(s1).getSocket().getOutputStream());
                        oos.writeObject(message);
                    }
                } else if (message.getMessageType().equals(MessageType.SEND_FILE_MESSAGE_TO_ONE)) {
                    ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectClient.getThreadByUserId(message.getGetter()).getSocket().getOutputStream());
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
