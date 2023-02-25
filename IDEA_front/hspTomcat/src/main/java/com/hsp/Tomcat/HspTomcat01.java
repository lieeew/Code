package com.hsp.Tomcat;

import sun.security.x509.IPAddressName;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/2/24
 * @Description: 这是第一版的tomcat
 */
public class HspTomcat01 {
    public static void main(String[] args) {
        // 1. 创建ServerSocket, 在8080端口监听
        InputStream inputStream = null;
        Socket socket = null;
        BufferedReader bufferedReader = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("====服务器在8080端口监听====");
            while (!serverSocket.isClosed()) {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String message = null;
                System.out.println("接收到浏览器发送的数据~~");
                while ((message = bufferedReader.readLine()) != null) {
                    if (message.length() == 0) { //字符串没有东西
                        return;
                    }
                    System.out.println(message);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
