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

    public void checkUer(String account, String psw) {
        u.setUserId(account);
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

            } else {
                // 登录失败
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


