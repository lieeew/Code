package QQServer.server.Server;

import com.qqcommon.Message;
import com.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/27 - 11 - 27
 * @Description: QQServer.server
 * 主线程
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId;


    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) { // 需要不停的发送信息
            try {
                System.out.println("服务端和客户端" + userId + "保持通信");
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)objectInputStream.readObject();
                // 得到这个message, 说明业务类型
                if (message.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    Message message2 = new Message();
                    System.out.println(message.getSender() + " 要在线文档");
                    message2.setMessageType(MessageType.MESSAGE_RED_ONLINE_FRIEND);
                    message2.setContent (onlineUser);
                    message2.setGetter(message.getSender()); // getter接收
                    // 把message2传入到客户端
                    ObjectOutputStream objectOutputStream =
                            new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(message2);
                } else if (MessageType.MESSAGE_LOGIN_FAIL.equals(message.getMessageType())) {
                    System.out.println(message.getSender() + "请求关闭线程");
                    ManageClientThreads.removeClientThread(message.getSender());
                    socket.close();
                    break; // 必须关闭
                } else if (MessageType.MESSAGE_COME_MES.equals(message.getMessageType())) {
                    // 根据message获取 getterId ,然后在得到对应线程
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getClientThread(message.getGetter());
                    // 得到对应socket对应的对象输出流, 再讲message发给对应的客户端
                    ObjectOutputStream objectOutputStream =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    objectOutputStream.writeObject(message);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
