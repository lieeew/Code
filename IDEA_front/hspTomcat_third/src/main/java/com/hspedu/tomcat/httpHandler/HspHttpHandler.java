package com.hspedu.tomcat.httpHandler;

import com.hspedu.tomcat.HspTomcatV3;
import com.hspedu.tomcat.http.HspRequest;
import com.hspedu.tomcat.http.HspResponse;
import com.hspedu.tomcat.servlet.HspHttpServlet;
import com.hspedu.tomcat.servlet.OkServlet;
import com.hspedu.tomcat.utils.WebUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description:
 */
public class HspHttpHandler implements Runnable {
    // 持有这个socket处理数据
    private Socket socket;

    public HspHttpHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // System.out.println(Thread.currentThread().getName() + "\n\n\n\n");
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String mes = "";
//            System.out.println("从服务器获取的数据: ");
//            while ((mes = bufferedReader.readLine()) != null) {
//                if (mes.length() == 0) {
//                    break;
//                }
//                System.out.println(mes);
//            }
            HspRequest hspRequest = new HspRequest(socket.getInputStream());
            HspResponse hspResponse = new HspResponse(socket.getOutputStream());
//            System.out.println("向浏览器发送数据: ");
//            OutputStream outputStream = socket.getOutputStream();
//            String header = "HTTP/2 200 OK\r\n" +
//                    "content-type: text/html;charset=UTF-8\r\n\r\n";
//            String str = header + "<h1>韩顺平教育!!!!<h1>";
//            System.out.println(str);
//            outputStream.write(str.getBytes());
//            outputStream.flush();
//            outputStream.close();
//            socket.close();

            // 后面使用反射方式调用
//            OkServlet okServlet = new OkServlet();
//            okServlet.service(hspRequest, hspResponse);
            // 过滤一下
            String uri = hspRequest.getUri();
            if (WebUtils.isHtml(uri)) {
                String htmlContent = WebUtils.getHtmlContent(uri);
                OutputStream outputStream = hspResponse.getOutputStream();
                outputStream.write(htmlContent.getBytes());
                outputStream.flush();
                outputStream.close();
                return;
            }

            if (uri == null) {
                uri = "";
            }
            String servletName = HspTomcatV3.ServletMappingHash.get(uri);
            if (servletName == null) {
                OutputStream outputStream = hspResponse.getOutputStream();
                outputStream.write((HspResponse.Header + "<h1>404 NOT FOUND~~<h1>").getBytes());
                outputStream.flush();
                outputStream.close();
            } else {
                HspTomcatV3.ServletHash.get(servletName).service(hspRequest, hspResponse);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
