package qqclient.service;

import qqcommen.Message;
import qqcommen.MessageType;

import javax.xml.transform.Source;
import java.io.*;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/1/29 15
 * @Description: 线程相关
 */
public class clientConnectServiceThread extends Thread{
    private Socket socket;

    // 传入socket数据
    public clientConnectServiceThread(Socket socket) {
        this.socket = socket;
    }
    // 获取当前socket
    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("客户端线程, 等待服务端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject(); // 如果没有消息, 就会一直卡在这里
                if (message.getMessageType().equals(MessageType.MESSAGE_RED_ONLINE_FRIEND)) {
                    String content = message.getContent();
                    String[] s = content.split(" ");
                    System.out.println();
                    for (String str : s) {
                        System.out.println("用户 : " + str);
                    }
                } else if (message.getMessageType().equals(MessageType.MESSAGE_COME_MES)) {
                    System.out.println("\n\n" + message.getSender() + " 对 " + message.getGetter() + " 说 " + message.getContent());
                } else if (message.getMessageType().equals(MessageType.SEND_MESSAGE_TO_ALL)) {
                    System.out.println("\n\n" + message.getSender() + " 对 大家 说 " + message.getContent());
                } else if (message.getMessageType().equals(MessageType.SEND_FILE_MESSAGE_TO_ONE)) {
                    File file = new File(message.getDesc());
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                    bos.write(message.getBytes());
                    System.out.println("\n\n" + message.getSender() + " 发送给 " + message.getGetter() + " 存放的位置是 " + message.getDesc());
                } else {
                    System.out.println("其他来自服务器的消息类型");
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
