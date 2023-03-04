package com.hspedu;

import com.hspedu.tomcat.handler.HspRequestHandler;
import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/3/4
 * @Description:
 */
public class hspTomcatV2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (!serverSocket.isClosed()) {
                System.out.println("======hspTomcatV2=======");
                // 这个socket就是浏览器和服务器的数据通道
                Socket socket = serverSocket.accept();
                // 分发请求
                HspRequestHandler hspRequestHandler = new HspRequestHandler(socket);
                new Thread(hspRequestHandler).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
