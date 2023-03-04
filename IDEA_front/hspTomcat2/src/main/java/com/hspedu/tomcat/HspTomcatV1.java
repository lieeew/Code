package com.hspedu.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 韩顺平
 * @version 1.0
 * 这是第一个版本的tomcat ,可以完成，接收浏览器的请求，并返回信息
 */
public class HspTomcatV1 {
    public static void main(String[] args) throws IOException {

        //1. 创建ServerSocket, 在 8080端口监听
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("=======mytomcat在8080端口监听======");
        while (!serverSocket.isClosed()) {

            //等待浏览器/客户端的连接
            //如果有连接来，就创建一个socket
            //这个socket就是服务端和浏览器端的连接/通道
            Socket socket = serverSocket.accept();

            //先接收浏览器发送的数据
            //inputStream 是字节流=> BufferedReader(字符流)
            //java基础 IO , 第19章
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

            String mes = null;
            System.out.println("=======接收到浏览器发送的数据=======");
            //循环的读取
            while ((mes = bufferedReader.readLine()) != null) {
                //判断mes的长度是否为0
                if (mes.length() == 0) {
                    break;//退出while
                }
                System.out.println(mes);
            }

            //我们的tomcat会送-http响应方式
            OutputStream outputStream = socket.getOutputStream();
            //构建一个http响应的头
            //\r\n 表示换行
            //http响应体，需要前面有两个换行 \r\n\r\n
            String respHeader = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html;charset=utf-8\r\n\r\n";
            String resp = respHeader + "hi, hspedu 韩顺平教育";

            System.out.println("========我们的tomcat 给浏览器会送的数据======");
            System.out.println(resp);

            outputStream.write(resp.getBytes());//将resp字符串以byte[] 方式返回

            outputStream.flush();
            outputStream.close();
            inputStream.close();
            socket.close();
            // //等会
            // inputStream.close();
            // socket.close();
        }
    }
}
