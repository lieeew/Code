package qqService;

import mysqlService.service.UserService;
import org.w3c.dom.events.MutationEvent;
import qqcommen.Message;
import qqcommen.MessageType;
import qqcommen.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/1/29 17
 * @Description: 这是服务器，在监听9999，等待客户端的连接，并保持通信
 */
public class qqService {
    private ServerSocket serverSocket;
    private UserService userService = new UserService(); // 数据库相关

    public qqService() {
        System.out.println("服務器在9999端口監聽");
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User u = (User) ois.readObject();

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();
                if (userService.check(u.getUserId(), u.getPsw())) {
                    // 账号密码正确
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    serverConnectClientThread serverConnectClientThread = new serverConnectClientThread(socket, u.getUserId());
                    serverConnectClientThread.start();
                    // 添加线程管理集合
                    ManageServerConnectClient.addToMangeHp(u.getUserId(), serverConnectClientThread);

                    if (OffLineService.HaveOffLineMessage(u.getUserId())) {
                        Message mes = OffLineService.getMessage(u.getUserId());
                        ObjectOutputStream objectOutputStream
                                = new ObjectOutputStream(ManageServerConnectClient.getThreadByUserId(u.getUserId()).getSocket().getOutputStream());
                        objectOutputStream.writeObject(mes);
                        OffLineService.removeMessage(u.getUserId());
                    }
                } else {
                    // 账号密码错误
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close(); // 关闭资源
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
