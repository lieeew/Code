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
                        break;
                    }
                    System.out.println(message);
                }

                // 我们的tomcat会发送http响应的方式
                OutputStream outputStream = socket.getOutputStream();
                // 构建一个http响应的头部
                // \r\n 表示换行 (回车换行)
                // http响应体，需要前面有两个换行 \r\n\r\n
                String respHeader = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html;charset=utf-8\r\n\r\n";
                // 响应体和响应头之间会以一个换行
                String rep = respHeader + "hi, hspedu 韩顺平教育";
                System.out.println("============浏览器发送的内容==========");
                System.out.println(rep);
                outputStream.write(rep.getBytes()); // 把rep以byte[]数组发送给过去取
                outputStream.flush();
                inputStream.close();
                outputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
