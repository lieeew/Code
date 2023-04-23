package com.hspedu.tomcat;

import com.hspedu.tomcat.httpHandler.HspHttpHandler;
import com.hspedu.tomcat.servlet.HspHttpServlet;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description: 最终版本 使用dom4j + 反射调用
 */
public class HspTomcatV3 {
    /*
   <servlet>
        <servlet-name>OkServlet</servlet-name>
        <servlet-class>com.hspedu.tomcat.servlet.OkServlet</servlet-class>
  </servlet>
  <servlet-mapping>
        <servlet-name>OkServlet</servlet-name>
        <url-pattern>/Ok</url-pattern>
  </servlet-mapping>
     */
    public static ConcurrentHashMap<String, String> ServletMappingHash = new ConcurrentHashMap<String, String>();

    public static ConcurrentHashMap<String, HspHttpServlet> ServletHash = new ConcurrentHashMap<String, HspHttpServlet>();

    public void init() {
        SAXReader saxReader = new SAXReader();
        String path = HspHttpHandler.class.getResource("/").getPath();
        try {
            Element rootElement = saxReader.
                    read(new File(path + "web.xml"))
                    .getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                if ("servlet".equals(element.getName())) {
                    // System.out.println("servlet~~~");
                    String text = element.element("servlet-name").getText();
                    ServletHash.put(element
                                    .element("servlet-name")
                                    .getText(),
                            (HspHttpServlet) Class.
                                    forName(element.element("servlet-class").getText())
                                    .newInstance());
                } else if ("servlet-mapping".equals(element.getName())) {
                    // System.out.println("servlet-mapping~~~");
                    ServletMappingHash.put(
                            element
                                    .element("url-pattern")
                                    .getText(),
                            element
                                    .element("servlet-name")
                                    .getText());
                }
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ServletHash = " + ServletHash);
        System.out.println("ServletMappingHash = " + ServletMappingHash);
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                new Thread(new HspHttpHandler(socket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        HspTomcatV3 hspTomcatV3 = new HspTomcatV3();
        hspTomcatV3.init();

        hspTomcatV3.run();
    }
}
