package com.hspedu.Spring.hspapplicationcontext;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: HspApplicationContext
 * Package: com.hspedu.Spring.hspapplicationcontext
 *
 * @Author: leikooo
 * @Creat: 2023/5/17 - 15:50
 * @Description:
 * 1. 这个程序用于实现Spring的一个简单容器机制
 * 2. 后面还会详细的实现
 * 3. 这里我们通过beans.xml文件记性解析, 并生成对象, 放入放到容器之中
 * 4. 提供一个方法 getBean(id) 返回对用的对象
 * 5. 只是一个开胃小点心
 */
public class HspApplicationContext {
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>();

    // 构造器
    // 接收容器的配置文件
    public HspApplicationContext(String iocBeanXmlFile) {
        SAXReader saxReader = new SAXReader();
        String path = HspApplicationContext.class.getResource("/").getPath();
        System.out.println(path);
        try {
            Document document = saxReader.read(new File(path + iocBeanXmlFile));
            Element rootElement = document.getRootElement();
            Element bean = rootElement.elements("bean").get(0);
            
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

}
