package com.hsp.Tomcat;

import com.hsp.Tomcat.handler.HspRequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/2/26
 * @Description:
 */
public class HspTomcatV2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("tomcatV2版本~~~");
        // 只要浏览器没有关闭就ok
        while (!serverSocket.isClosed()) {
            Socket socket = serverSocket.accept();
            // 1. 接收浏览器连接后, 如果成功就会的得到socket
            // 2. 这个socket就是服务器和浏览器的通信线程
            // 这个是Java线程基础      两次请求(网页数据 + 小图标)
            new Thread(new HspRequestHandler(socket)).start();
        }
    }
}
