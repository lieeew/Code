package ClientServer.service;

import ClientServer.utils.Utility;
import common.Message;
import common.MessageType;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/9 - 12 - 09
 * @Description: ClientServer.service
 */
public class clientConnectServiceThread extends Thread{
    private Socket socket; // 需要持有这个socket和服务器联系

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 需要一直读取数据
        while (true) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                if (MessageType.MESSAGE_LOGIN_SUCCEED.equals(message.getMessageType())) {
                    System.out.println("登录" + message.getSenderId() + "成功！");
                } else if (MessageType.MESSAGE_COME_MES.equals(message.getMessageType())) {
                    System.out.println("\n\n" + message.getSenderId() + " 发给 " + message.getGetterId() + " 的内容为: " + message.getCount());
                } else if (MessageType.MESSAGE_RED_ONLINE_FRIEND.equals(message.getMessageType())) {
                    String count = message.getCount();
                    String[] s = count.split(" ");
                    for (String str : s) {
                        System.out.println("用户: " + str);
                    }
                } else if (MessageType.SEND_MESSAGE_TO_ALL.equals(message.getMessageType())) {
                    System.out.println("\n\n" + message.getSenderId() + " 对大家说 " + message.getCount());
                } else if (MessageType.SEND_FILE_MESSAGE_TO_ONE.equals(message.getMessageType())) {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(message.getDes()));
                    bufferedOutputStream.write(message.getBytes());
                    System.out.println("\n\n" + message.getSenderId() + " 发给 " +
                            message.getGetterId() + " 的文件存储在 " + message.getDes() + " 路径下!");
                }
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
