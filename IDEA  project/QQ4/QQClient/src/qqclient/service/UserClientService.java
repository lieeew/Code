package qqclient.service;

import qqclient.utils.Utility;
import qqcommen.Message;
import qqcommen.MessageType;
import qqcommen.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/1/29 15
 * @Description:
 */
public class UserClientService {
    private User u = new User(); // 会在外面使用到user属性
    private Socket socket;

    /**
     * 登录检查
     *
     * @param userId userId
     * @param psw    密码
     * @return true表示登录成功
     */
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

            if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
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

    /**
     * 获取用戶列表
     */
    public void showUserList() {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServiceThread.getThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 退出系统的方法
     */
    public void logOut() {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXI);
        message.setSender(u.getUserId());

        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServiceThread.getThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 退出系统
            System.exit(0);
        }
    }

    /**
     * 私聊消息
     *
     * @param getter  接收者
     * @param sender  发送者
     * @param content 私聊内容
     */
    public void SendMessageToOne(String getter, String sender, String content) {
        Message message = new Message();
        message.setSender(sender);
        message.setGetter(getter);
        message.setContent(content);
        message.setMessageType(MessageType.MESSAGE_COME_MES);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServiceThread.getThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n" + sender + " 对 " + getter + " 说 " + content);
    }

    /**
     * 私聊消息
     *
     * @param sender  发送者
     * @param content 内容
     */
    public void SendMessageToAll(String sender, String content) {
        Message message = new Message();
        message.setSender(sender);
        message.setContent(content);
        message.setMessageType(MessageType.SEND_MESSAGE_TO_ALL);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServiceThread.getThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n" + sender + " 对 " + "大家" + " 说 " + content);
    }

    /**
     * 发送文件
     *
     * @param src    源文件的位置
     * @param dest   目标文件的位置
     * @param getter 接收者
     * @param sender 发送者
     */
    public void sendFile(String src, String dest, String getter, String sender) {
        File file = new File(src);
        byte[] bytes = new byte[(int) file.length()]; // 根据文件的大小一次性创建一个
        Message message = new Message();
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            bis.read(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            message.setBytes(bytes);
            message.setMessageType(MessageType.SEND_FILE_MESSAGE_TO_ONE);
            message.setGetter(getter);
            message.setSender(sender);
            message.setSrc(src);
            message.setDesc(dest);
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


