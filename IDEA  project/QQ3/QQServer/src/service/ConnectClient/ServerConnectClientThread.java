package service.ConnectClient;

import common.Message;
import common.MessageType;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/9 - 12 - 09
 * @Description: service.ConnectClient
 * 该线程与客户端的摸一个对象保持联系
 */

public class ServerConnectClientThread extends Thread {
    private String userId; // 便于寻找哪一个线程
    private Socket socket; // 握住这一个线程

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) { // 不停的监听
            try {
                System.out.println(userId + " 与服务器保持通信！");
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                // 以后处理业务逻辑都在这里
                if (MessageType.MESSAGE_COME_MES.equals(message.getMessageType())) {

                    ObjectOutputStream objectOutputStream =
                            new ObjectOutputStream(ManageClientThreads.getThread(message.getGetterId()).getSocket().getOutputStream());
                    objectOutputStream.writeObject(message);
                } else if (MessageType.MESSAGE_GET_ONLINE_FRIEND.equals(message.getMessageType())) {
                    message.setMessageType(MessageType.MESSAGE_RED_ONLINE_FRIEND);
                    HashMap<String, ServerConnectClientThread> hashMap = ManageClientThreads.getHashMap();
                    Iterator<String> iterator = hashMap.keySet().iterator();
                    String str = "";
                    while (iterator.hasNext()) {
                        str += iterator.next() + " "; // 必须调用next()方法
                    }
                    message.setCount(str);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(getSocket().getOutputStream());
                    objectOutputStream.writeObject(message);
                } else if (MessageType.SEND_MESSAGE_TO_ALL.equals(message.getMessageType())) {
                    HashMap<String, ServerConnectClientThread> hashMap = ManageClientThreads.getHashMap();
                    Iterator<String> iterator = hashMap.keySet().iterator();
                    while (iterator.hasNext()) {
                            /*
                            这里如果iterator.next()写在里面就会有不一样的效果, 结果会有问题
                            由于next()只有输出对象的内容, 不知道,why?
                             */
                            String next = iterator.next();
                            if (!next.equals(message.getSenderId())) {
                                ObjectOutputStream objectOutputStream =
                                        new ObjectOutputStream(hashMap.get(next).getSocket().getOutputStream());
                                objectOutputStream.writeObject(message);
                        }
                    }
                } else if (MessageType.MESSAGE_CLIENT_EXI.equals(message.getMessageType())) {
                    System.out.println(message.getSenderId() + " 要退出系统!");
                    ManageClientThreads.removeThread(message.getSenderId());
                    socket.close();
                    break; //如果不break那么在走一圈就会报非常多的异常
                } else if (MessageType.SEND_FILE_MESSAGE_TO_ONE.equals(message.getMessageType())) {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientThreads.getThread(message.getGetterId()).getSocket().getOutputStream());
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
