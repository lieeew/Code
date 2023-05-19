package com.hspedu.Spring.hspapplicationcontext;

import com.hspedu.Spring.bean.Monster;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: HspApplicationContext
 * Package: com.hspedu.Spring.hspapplicationcontext
 *
 * @Author: leikooo
 * @Creat: 2023/5/17 - 15:50
 * @Description: 1. 这个程序用于实现Spring的一个简单容器机制
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
            // 得到根元素
            Element rootElement = document.getRootElement();
            // 得到第一个monster01对象
            Element bean = rootElement.elements("bean").get(0);
            // 获取第一个monster01的相关属性
            String id = bean.attributeValue("id");
            String classFullPatch = bean.attributeValue("class");
           // System.out.println("id = " + id);
            List<Element> property = bean.elements("property");
            int monsterId = Integer.parseInt(property.get(0).attributeValue("value"));
            String name = property.get(1).attributeValue("value");
            String skill = property.get(2).attributeValue("value");

           // System.out.println("monsterId = " + monsterId);
           // System.out.println("name = " + name);
           // System.out.println("skill = " + skill);

            // 使用反射创建对象
            Class<?> aClass = Class.forName(classFullPatch);
            Monster monster = (Monster) aClass.newInstance();
            // 使用反射赋值
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if ("setName".equals(method.getName())) {
                    method.invoke(monster, name);
                } else if ("setMonsterId".equals(method.getName())) {
                    method.invoke(monster, monsterId);
                } else if ("setSkill".equals(method.getName())) {
                    method.invoke(monster, skill);
                }
            }
           // System.out.println("monster = " + monster);

            // 最后把创建好的对象放入到 singletonObjects
            singletonObjects.put(id, monster);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Object getBean(String id) {
        return singletonObjects.get(id);
    }
}
