package qqclient.service;

import qqcommen.Message;
import qqcommen.MessageType;
import qqcommen.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/1/29 15
 * @Description:
 */
public class userClientService {
    private User u = new User(); // 会在外面使用到user属性
    private Socket socket;

    public boolean checkUer(String userId, String psw) {
        boolean isSuccess = true;
        u.setUserId(userId);
        u.setPsw(psw);
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            // 读取从服务器返回的数据
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();

            if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCESS)) {
                // 登录成功, 需要一个线程持有该socket, 保持和服务器的通信
                // 启动线程
                clientConnectServiceThread clientConnectServiceThread = new clientConnectServiceThread(socket);
                clientConnectServiceThread.start();
                // 加入到线程管理的集合
                ManageClientConnectServiceThread.addClientThread(userId, clientConnectServiceThread);
            } else {
                // 登录失败, 需要关不socket
                socket.close();
                isSuccess = false;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return isSuccess;
    }
}


