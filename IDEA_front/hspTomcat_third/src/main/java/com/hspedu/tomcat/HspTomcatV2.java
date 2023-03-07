package com.hspedu.tomcat;

import com.hspedu.tomcat.httpHandler.HspHttpHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description: 这个版本我要加上线程, 上一个版本不支持线程
 */
public class HspTomcatV2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
           while (!serverSocket.isClosed()) {
               Socket accept = serverSocket.accept();
               new Thread(new HspHttpHandler(accept)).start();
           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
