package com.hspedu;

import com.hspedu.tomcat.handler.HspRequestHandler;
import com.hspedu.tomcat.servlet.hspHttpServlet;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.sql.rowset.spi.XmlReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: qxy
 * @Date: 2023/3/4
 * @Description: 通过xml + 容器初始化到容器
 */
public class HspTomcatV3 {
    /*
          <servlet>
                <servlet-name>calServlet</servlet-name>
                <servlet-class>com.hspedu.tomcat.servlet.hspCalServlet</servlet-class>
          </servlet>
          <servlet-mapping>
                <servlet-name>calServlet</servlet-name>
                <url-pattern>/calServlet</url-pattern>
          </servlet-mapping>
         */
    // servletMapping
    // 使用ConcurrentHashMap
    // key  servletName
    // value 对应的实例

    public static final ConcurrentHashMap<String, hspHttpServlet> servletMapping = new ConcurrentHashMap<String, hspHttpServlet>();

    // servletUrlMapping
    // key  url-pattern
    // value  servletName
    public static final ConcurrentHashMap<String, String> servletUrlMapping = new ConcurrentHashMap<String, String>();

    // 自己对两个容器初始化
    public void init() {
        String path = HspTomcatV3.class.getResource("/").getPath();
        // System.out.println("path = " + path);
        // 使用dom4j技术读取
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new File(path + "web.xml"));
            // System.out.println("read = " + read);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
            // 遍历并过滤
            for (Element element : elements) {
                if ("servlet".equalsIgnoreCase(element.getName())) {
                    // System.out.println("发现servlet节点");
                    Element servlrtName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    servletMapping.put(servlrtName.getText(),
                            (hspHttpServlet) Class.forName(servletClass.getText().trim()).newInstance());

                } else if ("servlet-mapping".equalsIgnoreCase(element.getName())){
                    // System.out.println("发现servlet-mapping节点");
                    Element servletName = element.element("servlet-name");
                    Element urlPattern = element.element("url-pattern");
                    servletUrlMapping.put(urlPattern.getText(), servletName.getText());
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
        // 测试一下, 非常的完美
        System.out.println(servletMapping);
        System.out.println(servletUrlMapping);

    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                new Thread(new HspRequestHandler(socket)).start();
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
