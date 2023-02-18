package com.hsp.annotation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/2/18
 * @Description:
 */
public class TestAnnotationServlet {
    private static final HashMap<String, HttpServlet> hm = new HashMap<>();

    public static void main(String[] args) {
        // 1. 首先掃描包（sec下的所有）得到路徑
        String classPath = "com.hsp.annotation.OkServlet";
        // 2. 得到okServlet的class对象
        try {
            Class<?> aClass = Class.forName(classPath);
            // 通过class对象拿到Annotation
            WebServlet annotation = aClass.getAnnotation(WebServlet.class);
            String[] urlPatterns = annotation.urlPatterns();
            for (String urlPattern : urlPatterns) {
                System.out.println(urlPattern);
            }

            // 3. Tomcat产生一个OkServlet的实例, 放入到hashMap之中
            HttpServlet instance = (HttpServlet) aClass.newInstance();
            System.out.println(instance);
            hm.put("OkServlet", instance);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
