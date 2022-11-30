package QQClient.Service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;
import com.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/27 - 11 - 27
 * @Description: QQClient.Service
 */
public class userClientService {

    private User u = new User();
    boolean b ;
    Socket socket; // socket在其他地方有可能使用
    public boolean cheekUser (String userId, String password) {
        u.setUserId(userId);
        u.setPassWord(password);
        // 传输对象
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u); // 发送数据

            // 接收信息
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message)ois.readObject();

            if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                System.out.println("登录成功"); // 需要创建一共线程
                clientConnectServiceThread clientConnectServiceThread = new clientConnectServiceThread(socket);
                clientConnectServiceThread.start(); // 启动线程
                // 为了以后的扩张性, 需要添加到一个管理的类中
                ManageClientConnectServiceThread.addClientConnectServerThread(userId, clientConnectServiceThread);
                b = true;
            } else {
                System.out.println("登录失败");
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return b;
    }
    // 向服务器请求在线用户列表
    public void getOnlineFriendList() {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        // 获取Socket对象, 向发送服务器发送请求
        clientConnectServiceThread thread = new ManageClientConnectServiceThread().getThread(u.getUserId());
        try {
            OutputStream outputStream = thread.getSocket().getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // 退出线程发送信号
    public void logout() {
        Message mes = new Message();
        mes.setMessageType(MessageType.MESSAGE_CLIENT_EXI);
        mes.setSender(u.getUserId()); // 一定要确定我是哪一个
        try {
            clientConnectServiceThread thread = new ManageClientConnectServiceThread().getThread(u.getUserId());
            OutputStream outputStream = thread.getSocket().getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(mes);
            System.out.println(u.getUserId() + ", 退出系统!");
            System.exit(0); // 结束线程
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
