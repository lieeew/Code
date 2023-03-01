package com.hsp.Tomcat.handler;

/**
 * @Author: qxy
 * @Date: 2023/2/26
 * @Description:
 */

import com.hsp.http.HspRequest;

import java.io.*;
import java.net.Socket;

/**
 * 老韩解读
 * 1. HspRequestHander 对象是一个线程对象
 * 2. 处理一个http请求
 */
public class HspRequestHander implements Runnable{
    // 定义一个socket
    private Socket socket = null;

    public HspRequestHander(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            // 把字节流转化为字符流 inputStream -> BufferedReader
            // 转化的原因 : 方便按行读取
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
//            // 不同线程在和浏览器和客户端交互
//            System.out.println("线程名字 : " + Thread.currentThread().getName());
//
//            String mes = null;
           System.out.println("=========hspTomcat2 进行读取数据如下=========");
//            while ( (mes = bufferedReader.readLine()) != null) {
//                if (mes.length() == 0) { // 长度为0即为""
//                    break;
//                }
//                System.out.println(mes);
//            }

            // 先死后活
            HspRequest hspRequest = new HspRequest(inputStream);
            String num1 = hspRequest.getParameterts("num1");
            String num2 = hspRequest.getParameterts("num2");
            System.out.println("請求的參數num1 = " + num1);
            System.out.println("請求的參數num2 = " + num2);
            System.out.println("HspRequest" + hspRequest);
            // 返回数据我们的浏览器/客户端 -> 封装成http响应
            OutputStream outputStream = socket.getOutputStream();
            // 构建一个响应头
            String respHeader = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html;charset=utf-8\r\n\r\n";
            // 响应体和响应头之间必须有两个换行 \r\n\r\n
            String resp = respHeader + "<h1>hspedu 韩顺平教育</h1>";
            System.out.println("=======hspTomcatv2返回的数据=======");
            System.out.println(resp);
            outputStream.write(resp.getBytes()); // getBytes()把字符串转化为字节流
            outputStream.flush();
            outputStream.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 最后一定要确保socket关闭
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
