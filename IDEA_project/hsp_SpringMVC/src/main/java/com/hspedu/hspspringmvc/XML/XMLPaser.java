package com.hspedu.hspspringmvc.XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.sql.rowset.spi.XmlReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

/**
 * ClassName: XMLPaser
 * Package: com.hspedu.hspspringmvc.XML
 *
 * @Author: leikooo
 * @Creat: 2023/6/12 - 13:45
 * @Description: 解析 xml 文件
 */
public class XMLPaser {

    /**
     * 解析 xml 文件
     * @param xmlFile xml 文件的名称
     * @return
     */
    public static String getBasePackage(String xmlFile) {
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
