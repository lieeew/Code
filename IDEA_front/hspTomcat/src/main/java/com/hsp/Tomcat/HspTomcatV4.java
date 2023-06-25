package com.hsp.Tomcat;

import com.hsp.Tomcat.handler.HspRequestHandler;
import com.hsp.Tomcat.servlet.HspHttpServlet;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.Filter;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 韩顺平
 * @version 1.0
 * 第3版的Tomcat, 实现通过xml+反射来初始化容器
 */
public class HspTomcatV4 {

    //1. 存放容器 servletMapping
    // -ConcurrentHashMap
    // -HashMap
    // key            - value
    // ServletName    对应的实例

    public static final ConcurrentHashMap<String, HspHttpServlet>
            servletMapping = new ConcurrentHashMap<>();


    //2容器 servletUrlMapping
    // -ConcurrentHashMap
    // -HashMap
    // key                    - value
    // url-pattern       ServletName

    public static final ConcurrentHashMap<String, String>
            servletUrlMapping = new ConcurrentHashMap<>();


    //你可以这里理解session, tomcat还维护一个容器
    public static final ConcurrentHashMap<String, HttpSession>
            sessionMapping = new ConcurrentHashMap<>();


    //你可以这里理解filter, tomcat还维护了filter的容器
    public static final ConcurrentHashMap<String, String>
            filterUrlMapping = new ConcurrentHashMap<>();

    public static final ConcurrentHashMap<String, Filter>
            filterMapping = new ConcurrentHashMap<>();

    //启动HspTomcatV3容器
    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("=====hspTomcat v3在8080监听======");
            Socket socket = serverSocket.accept();

            while (!serverSocket.isClosed()) {
                HspRequestHandler hspRequestHandler = new HspRequestHandler(socket);
                new Thread(hspRequestHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //直接对两个容器进行初始化
    public void init() {
        //读取web.xml => dom4j =>
        //得到web.xml文件的路径 => 拷贝一份.
        String path = HspTomcatV3.class.getResource("/").getPath();
        //System.out.println("path= " + path);
        //使用dom4j技术完成读取
        SAXReader saxReader = new SAXReader();
        //困难->真的掌握
        try {
            Document document = saxReader.read(new File(path + "web.xml"));
            System.out.println("document= " + document);
            //得到根元素
            Element rootElement = document.getRootElement();
            //得到根元素下面的所有元素
            List<Element> elements = rootElement.elements();
            //遍历并过滤到 servlet servlet-mapping
            for (Element element : elements) {
                if ("servlet".equalsIgnoreCase(element.getName())) {
                    //这是一个servlet配置
                    //System.out.println("发现 servlet");
                    //使用反射将该servlet实例放入到servletMapping
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    servletMapping.put(servletName.getText(),
                            (HspHttpServlet) Class.forName(servletClass.getText().trim()).newInstance());
                } else if ("servlet-mapping".equalsIgnoreCase(element.getName())) {
                    //这是一个servlet-mapping
                    //System.out.println("发现 servlet-mapping");

                    Element servletName = element.element("servlet-name");
                    Element urlPatter = element.element("url-pattern");
                    servletUrlMapping.put(urlPatter.getText(), servletName.getText());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //老韩验证，这两个容器是否初始化成功
        System.out.println("servletMapping= " + servletMapping);
        System.out.println("servletUrlMapping= " + servletUrlMapping);
    }

    //变强..
    public static void main(String[] args) {
        HspTomcatV4 hspTomcatV4 = new HspTomcatV4();
        hspTomcatV4.init();
        //启动 hspTomcat 容器
        hspTomcatV4.run();
    }
}
