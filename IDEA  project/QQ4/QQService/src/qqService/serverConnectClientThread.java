package qqService;

import qqcommen.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/1/29 23
 * @Description: 该类和客户端某一个线程保持通信
 */
public class serverConnectClientThread extends Thread {
    private Socket socket;
    private String userId; // 链接到服务器的id, 区分用户

    public serverConnectClientThread() {
    }

    public serverConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("客户单和服务器保持通信, 读取数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject(); // 没有消息就会阻塞在这里

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
