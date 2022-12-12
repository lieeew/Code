package ClientServer.service;

import common.Message;
import common.MessageType;
import common.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/9 - 12 - 09
 * @Description: ClientServer.service
 */
public class MessageClientService {
    /**
     *  检查密码是否正确
     * @param count 账号
     * @param password 密码
     * @return
     */
    public boolean checkUser(String count, String password) {
        try {
            clientConnectServiceThread clientConnectServiceThread = new clientConnectServiceThread();
            ManageClientConnectServerThread manageClientConnectServerThread = new ManageClientConnectServerThread();
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
            User user = new User(count, password);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(user);
            // 读取从服务器获得的数据message的类型, 进行判断
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message mes = (Message) objectInputStream.readObject();
            if (MessageType.MESSAGE_LOGIN_SUCCEED.equals(mes.getMessageType())) {
                clientConnectServiceThread.setSocket(socket);
                clientConnectServiceThread.start(); // 启动这个线程
                manageClientConnectServerThread.addThreadToManage(count, clientConnectServiceThread); // 把线程放入管理的集合之中
                return true;
            } else {
                System.out.println("用户: " + count + "密码为: " + password + " 登录失败!");
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取在线用户
     */
    public void getOnlineUsers(String account) {
        try {
            Message message = new Message();
            message.setCount(account);
            message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectService(account).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  私聊消息
     * @param getterId 接收者id
     * @param senderId 发送者者id
     * @param count 发送的内容
     */
    public void sendMessageToOne(String getterId, String senderId, String count) {
        Message message = new Message();
        message.setCount(count);
        message.setGetterId(getterId);
        message.setSenderId(senderId);
        message.setSentTime(new Date().toString());
        message.setMessageType(MessageType.MESSAGE_COME_MES);

        try {
            clientConnectServiceThread clientConnectService = ManageClientConnectServerThread.getClientConnectService(senderId);
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(clientConnectService.getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 群发消息了
     * @param senderId 发送者id
     * @param content 内容
     */
    public void sendMessageToAll (String senderId, String content) {
        Message message = new Message();
        message.setMessageType(MessageType.SEND_MESSAGE_TO_ALL);
        message.setSenderId(senderId);
        message.setCount(content);
        message.setSentTime(new Date().toString());

        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectService(senderId).getSocket().getOutputStream());
            objectOutputStream.writeObject(message); // 把message发给服务端
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 发送文件到对方的目录
     * @param des 接受者存放位置
     * @param src 发送者文件位置
     * @param getterId 接受者
     * @param senderId 发送者
     */
    public void sendFileToOne(String des, String src, String getterId, String senderId) {
        try {
            File file = new File(src);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[(int) file.length()];
            bufferedInputStream.read(bytes);
            Message message = new Message();
            message.setMessageType(MessageType.SEND_FILE_MESSAGE_TO_ONE);
            message.setBytes(bytes);
            message.setSenderId(senderId);
            message.setGetterId(getterId);
            message.setSentTime(new Date().toString());
            message.setDes(des);
            message.setSrc(src);
            // 服务器发送
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectService(senderId).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
