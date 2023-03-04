package com.hspedu.tomcat.handler;

import com.hspedu.HspTomcatV3;
import com.hspedu.tomcat.http.HspRequest;
import com.hspedu.tomcat.http.HspResponse;
import com.hspedu.tomcat.servlet.hspCalServlet;
import com.hspedu.tomcat.servlet.hspHttpServlet;

import java.io.*;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/3/4
 * @Description: 这个会分发请求 handler处理的意思
 */
public class HspRequestHandler implements Runnable {
    private Socket socket;

    public HspRequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            // InputStream inputStream = socket.getInputStream();
//            // inputStream -> bufferedReader(字符吗方便按行读取)
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            String mes = null;
//            System.out.println("===========hspTomcatV2版本接收的数据==========");
//            while ((mes = bufferedReader.readLine()) != null) {
//                if (mes.length() == 0) { // 长度为0不需要读取
//                    break;
//                }
//                System.out.println(mes);
//            }

            // 我们使用hspRquest进行操作
            HspRequest hspRquest = new HspRequest(socket.getInputStream());
            HspResponse hspResponse = new HspResponse(socket.getOutputStream());
//            String num1 = hspRquest.getParameter("num1");
//            String num2 = hspRquest.getParameter("num2");
//            System.out.println("请求的参数num1 = " + num1);
//            System.out.println("请求的参数num2 = " + num2);
//            System.out.println(hspRquest);
//            // 返回数据给浏览器/客户端
//            System.out.println("===========hspTomcatV2版本返回的数据==========");
//            String respHeader = "HTTP/1.1 200 OK\r\n" +
//                    "Content-Type: text/html;charset=utf-8\r\n\r\n";
//            String repMes = respHeader + "<h1>hi hsp教育~~~~~</h1>";
//            System.out.println(repMes);
//            OutputStream outputStream = socket.getOutputStream();
//            outputStream.write(repMes.getBytes());
//            outputStream.flush();
//            outputStream.close();
//            inputStream.close();

            // 一会使用反射进行
//            hspCalServlet hspCalServlet = new hspCalServlet();
//            hspCalServlet.service(hspRquest, hspResponse);
            String uri = hspRquest.getUri();
            // 通过  uri --> servletName
            String servletName = HspTomcatV3.servletUrlMapping.get(uri);
            // 通过servletName -->  类的实例化对象
            // 多态  子类指向父类, 真正的运行类型就是hspCalServlet
            hspHttpServlet hspHttpServlet = HspTomcatV3.servletMapping.get(servletName);
            // 通过动态绑定可以调用doGet/doPost
            hspHttpServlet.service(hspRquest, hspResponse);
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 確保要关闭, 否则会出现线程堆满
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
