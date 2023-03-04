package com.hsp.Tomcat;

import com.hsp.Tomcat.handler.HspRequestHandler;
import com.hsp.servlet.HspHttpServlet;
import org.dom4j.Document;
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
 * @Date: 2023/3/2
 * @Description: 演示Tomcat, 实现通过ml + 反射来初始化容器
 */
public class HspTomcatV3 {
    // 1. 存放容器 servletMapping
    // ConcurrentHashMap 不能为null值
    // key             value
    // Servlet-name  对应的实例

    public static final ConcurrentHashMap<String, HspHttpServlet> servletHashMapping = new ConcurrentHashMap<>();

    // 容器2 servletUrlMapping
    // key               value
    // url-pattern    ServletName

    public static final ConcurrentHashMap<String, String> servletUrlMapping = new ConcurrentHashMap<>();

    // 对俩个容器初始化
    public void init() {
        // 读取web.xml 使用dom4j
        // 得到web.xml文件的路径
        String path = HspTomcatV3.class.getResource("/").getPath();
        System.out.println("path = " + path);

        SAXReader saxReader = new SAXReader();
        try {
            Document read = saxReader.read(new File(path + "web.xml"));
            // System.out.println(read);
            // 得到根元素
            Element rootElement = read.getRootElement();
            // 得到根元素的所有元素
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                if ("servlet".equalsIgnoreCase(element.getName())) {
                    // System.out.println("发现一个servlet节点");
                    // 把找到的放入到 servletMapping之中
                    // 使用反射创建实例放入到servletMapping
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");

                    servletHashMapping.put(servletName.getText(),
                            (HspHttpServlet) Class.forName(servletClass.getText().trim()).newInstance());
                } else if ("servlet-mapping".equalsIgnoreCase(element.getName())) {
                    // System.out.println("发现一个servlet-mapping节点");
                    Element urlPattern = element.element("url-pattern");
                    Element servletName = element.element("servlet-name");
                    // 放入进去指定的集合之中
                    servletUrlMapping.put(urlPattern.getText(), servletName.getText());
                }
            }
        } catch (DocumentException | MalformedURLException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 验证容器是否初始化成功
        System.out.println("servletHashMap = " + servletHashMapping);
        System.out.println("servletUrlMapping = " + servletUrlMapping);
    }

    public void run() {
        try {
            System.out.println("======服务器在8080端口监听用======");
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();

            while (!serverSocket.isClosed()) {
                HspRequestHandler hspRequestHandler = new HspRequestHandler(socket);
                new Thread(hspRequestHandler).start();
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
