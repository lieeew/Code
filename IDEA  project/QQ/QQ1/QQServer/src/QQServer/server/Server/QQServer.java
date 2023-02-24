package QQServer.server.Server;

import com.qqcommon.Message;
import com.qqcommon.MessageType;
import com.qqcommon.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/27 - 11 - 27
 * @Description: QQServer.server
 */
public class QQServer {

    public static void main(String[] args) {
        new QQServer();
    }

    private ServerSocket serverSocket = null;
    // 这里可以使用可以处理并发的集合 CurrentHashMap 线程安全
    // HashMap 线程不安全
    private static HashMap<String, User> validUsers = new HashMap<>();

    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUsers.put("菩提老祖", new User("菩提老祖", "123456"));

    }
    private boolean checkUser (String userId, String passWord) { // 排除法
        if (validUsers.get(userId) == null) { // 说明userId中存在 validUsers的key中
            return false;
        }
        if (!(validUsers.get(userId).getPassWord().equals(passWord))) { // 密码错误
            return false;
        }
        return true;

    }

    public QQServer() {
        try {
            // 注意: 端口可以写在配置文件之中
//            Properties properties = new Properties();
//            properties.load(new FileInputStream("jdbc.properties"));
//            String port_number = properties.getProperty("Portnumber");
            System.out.println("服务器在" + 9999 + "端口监听...  ");
            serverSocket = new ServerSocket(9999);

            while (true) { // 客户端连接上会继续监听
                Socket accept = serverSocket.accept();
                // 如果没有客户链接就会阻塞
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(accept.getInputStream());
                // 需要创建一个输出流
                ObjectOutputStream oos =
                        new ObjectOutputStream(accept.getOutputStream());
                User u = (User) objectInputStream.readObject();
                // 定义message对象, 装备回复客户端
                Message mas = new Message();
                if (checkUser(u.getUserId(), u.getPassWord())) {

                    mas.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(mas);
                    //创建一个线程，和客户端保持通信，该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(accept, u.getUserId());
                    serverConnectClientThread.start();
                    // 把线程对象放入集合中
                    ManageClientThreads.addClientThread(u.getUserId(), serverConnectClientThread);
                } else {
                    System.out.println("登录失败" + "userId = " + u.getUserId() + "  password = " + u.getPassWord());
                    mas.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(mas); // 发送给客户端
                    accept.close(); // 关闭流
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
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

