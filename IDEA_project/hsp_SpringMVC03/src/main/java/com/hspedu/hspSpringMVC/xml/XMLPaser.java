package com.hspedu.hspSpringMVC.xml;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * @author leikooo
 * @create 2023-06-18 17:22
 * @Package com.hspedu.hspspringmvc.xml
 * @Description
 */
public class XMLPaser {

    /**
     * 扫描得到 xml 文件配置的包路径
     */
    public static String getBasicPath(String xmlFile) {
        SAXReader saxReader = new SAXReader();
        try {
            // 得到具体的路径
            InputStream inputStream = XMLPaser.class.getClassLoader().getResourceAsStream(xmlFile);
            Document document = saxReader.read(inputStream);
            Element rootElement = document.getRootElement();
            // 先拿到对应的属性
            Element element = rootElement.element("coponent-scarn");
            // System.out.println(basePackage);
            // 拿到属性之后在拿到节点对应的属性
            return element.attributeValue("base-package");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
