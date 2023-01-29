package qqclient.service;

import qqcommen.Message;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/1/29 15
 * @Description: 线程相关
 */
public class clientConnectServiceThread extends Thread{
    private Socket socket;

    // 传入socket数据
    public clientConnectServiceThread(Socket socket) {
        this.socket = socket;
    }
    // 获取当前socket
    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("客户端线程, 等待服务端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject(); // 如果没有消息, 就会一直卡在这里
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
