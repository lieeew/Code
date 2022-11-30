package QQClient.server;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;
import sun.nio.cs.FastCharsetProvider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/30 - 11 - 30
 * @Description: QQClient.server
 * 该类完成用户注册
 */
public class UserClientService {

    private User u = new User(); // 可能会在其他地方使用
    private Socket socket;

    // 到服务器验证是否合法
    public boolean checkUser(String userId, String passWorld) {
        boolean b = false;

        u.setUserId(userId);
        u.setPassWord(passWorld);

        // 连接到服务器
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            // 得到输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(u);

            // 从服务器读取发回的Message对象
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message message = (Message)objectInputStream.readObject();

            if (MessageType.MESSAGE_LOGIN_SUCCEED.equals(message.getMessageType())) {
                // 需要启动一个线程, 不停的和服务器连接
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start(); // 启动一个线程
                // 为了以后的扩展需要放在线程里面
                ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
                b = true;
            } else {
                //如果登录失败，我们就不能启动和服务器通信的线程，关闭socket
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return b;
    }
}
