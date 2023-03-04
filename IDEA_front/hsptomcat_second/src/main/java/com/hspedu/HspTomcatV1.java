package com.hspedu;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/3/3
 * @Description: 这个是第一个版本的tomcat可以放回相关信息
 */
public class HspTomcatV1 {
    public static void main(String[] args) {
        // 1.创建
        try {
            System.out.println("=========hspTomcatV1版本在8080端口监听=====");
            ServerSocket serverSocket = new ServerSocket(8080);
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                // 方便读取
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                String mes = null;
                // 接收到流浪器发送的数据
                while ((mes = bufferedReader.readLine()) != null) {
                    if (mes.length() == 0) {
                        break;
                    }
                    System.out.println(mes);
                }
                // /calServlet?num1=12&num2=18 HTTP/1.1
                // 構建输出流  \r\n回车换行
//                String respHead = "HTTP/1.1 200 OK\r\n" +
//                        "Content-Type: text/html;charset=utf-8\r\n\r\n";
                String respHeader = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html;charset=utf-8\r\n\r\n";
                String repMes = respHeader + "<h1>hi 韩顺平教育!!</h1>";
                System.out.println("======tomcat返回的数据=========");
                System.out.println(repMes);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(repMes.getBytes());
                outputStream.flush();
                outputStream.close();
                inputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
