package service.ConnectClient;

import common.Message;
import common.MessageType;
import common.User;
import org.jetbrains.annotations.NotNull;
import service.utils.Utility;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/9 - 12 - 09
 * @Description: service.ConnectClient
 * 这是一个服务器, 在监听9999, 等待客户端链接, 并且保持通信
 */
public class QQService {
    public static void main(String[] args) {
        new QQService();

    }

    public QQService() {
        try {
            System.out.println("服务器在9999端口监听:");
            ServerSocket serverSocket = new ServerSocket(9999); // 这个需要写在外面否则会报端口占用
            new Thread(new sendNewsToAll()).start();
            while (true) {
                // 指明客户端的信息
                Socket accept = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
                User user = (User) objectInputStream.readObject();
                Message message = new Message();
                ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread();
                if (checkUser(user)) {
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
                    objectOutputStream.writeObject(message); // 发送给客户端
                    serverConnectClientThread.setSocket(accept); // 握住这个socket
                    serverConnectClientThread.setUserId(user.getAccount());
                    serverConnectClientThread.start(); // 启动一个线程
                    ManageClientThreads.addThreadToManage(user.getAccount(), serverConnectClientThread);
                    System.out.println("用户：" + user.getAccount() + "登录成功！");
                    /*
                    如果写在里面的话， 外面只能登录一个
                    接受端会不停的输出新闻， 进入死循环
                    原因debug不出来, 不知道为何
                    好像这样的话可以创建一个线程专门用于客户端输入存到的位置
                    System.out.println("请输入新闻: ");
                    String news = Utility.readString(100);
                    sendNewsToAll(news);
                     */
                    if (OfflineDataStorage.isLineForInformation(user.getAccount())) {
                        Message oneInformation = OfflineDataStorage.getOneInformation(user.getAccount());
                        ObjectOutputStream oos = new ObjectOutputStream(ManageClientThreads.getThread(oneInformation.getGetterId()).getSocket().getOutputStream());
                        oos.writeObject(oneInformation);
                        OfflineDataStorage.removeInformation(user.getAccount()); // 删除用户
                    }
                } else {
                    message.setMessageType(MessageType.MESSAGE_RED_ONLINE_FRIEND);
                    accept.close();
                    System.out.println("用户：" + user.getAccount() + "密码：" + user.getPassword() + "登陆失败！");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static HashMap<String, User> hashMap = new HashMap<>();


    static {
        hashMap.put("100", new User("100", "123456"));
        hashMap.put("至尊宝", new User("至尊宝", "123456"));
        hashMap.put("紫霞仙子", new User("紫霞仙子", "123456"));
        hashMap.put("郭德纲", new User("郭德纲", "123456"));
    }
    public static boolean checkUser( User user) {
        User u = hashMap.get(user.getAccount());
        if (u == null) return false;
        if (!u.getPassword().equals(user.getPassword())) return false;
        return true;
    }

    public static void sendNewsToAll( String content) {
        while (true) {
            try {
                if (content.equalsIgnoreCase("EXIT")) {
                    System.out.println("退出新闻推送系统!");
                    break;
                }
                Message message = new Message();
                message.setMessageType(MessageType.SEND_MESSAGE_TO_ALL);
                message.setCount(content);
                message.setSentTime(new Date().toString());
                message.setSenderId("服务器");
                HashMap<String, ServerConnectClientThread> hashMap1 = ManageClientThreads.getHashMap();
                Iterator<String> iterator = hashMap1.keySet().iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(hashMap1.get(next).getSocket().getOutputStream());
                    objectOutputStream.writeObject(message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
