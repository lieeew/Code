package com.hspedu.tomcat;

import com.hspedu.tomcat.handler.HspRequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class HspTomcatV2 {
    public static void main(String[] args) throws IOException {
        //在 8080 端口监听
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("======= hsptomcat V2 在8080监听=======");
        //只要 serverSocket没有关闭，就一直等待浏览器/客户端的连接
        while (!serverSocket.isClosed()) {
            //1. 接收到浏览器的连接后，如果成功，就会得到socket
            //2. 这个socket 就是 服务器和 浏览器的数据通道
            Socket socket = serverSocket.accept();
            //3. 创建一个线程对象，并且把socket给该线程
            //  这个是java线程基础
            HspRequestHandler hspRequestHandler =
                    new HspRequestHandler(socket);
            new Thread(hspRequestHandler).start();

        }
    }
}
