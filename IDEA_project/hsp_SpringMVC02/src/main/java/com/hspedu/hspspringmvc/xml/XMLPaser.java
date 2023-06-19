package com.hspedu.hspspringmvc.xml;

import com.hspedu.hspspringmvc.context.HspWebApplicationContext;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

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
            Element element = rootElement.element("coponent-scarn");
            // System.out.println(basePackage);
            return element.attributeValue("base-package");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
