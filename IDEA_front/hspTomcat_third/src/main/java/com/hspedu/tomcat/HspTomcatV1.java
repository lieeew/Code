package com.hspedu.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description: hspTomcat第一个版本
 */
public class HspTomcatV1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String mes = "";
                System.out.println("从服务器获取的数据: ");
                while ((mes = bufferedReader.readLine()) != null) {
                    if (mes.length() == 0) {
                        break;
                    }
                    System.out.println(mes);
                }

                System.out.println("向浏览器发送数据: ");
                OutputStream outputStream = socket.getOutputStream();
                String header = "HTTP/2 200 OK\r\n" +
                        "content-type: text/html;charset=UTF-8\r\n\r\n";
                String str = header + "<h1>韩顺平教育!!!!<h1>";
                System.out.println(str);
                outputStream.write(str.getBytes());
                outputStream.flush();
                outputStream.close();
                socket.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
