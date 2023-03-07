package com.hspedu.tomcat.utils;

import com.hspedu.tomcat.http.HspResponse;
import com.hspedu.tomcat.httpHandler.HspHttpHandler;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description:
 */
public class WebUtils {

    public static int parseInt(String s, int defaultNum) {
        int i = defaultNum;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("转化失败!!!!");
        }
        return i;
    }

    /**
     * 判断是否是html页面
     */

    public static boolean isHtml(@NotNull String uri) {
        return uri.endsWith(".html");
    }

    /**
     * 返回静态页面资源
     */
    public static String getHtmlContent(String name) {
        try {
            name = name.substring(1); //OkServlet
            String path = HspHttpHandler.class.getResource("/").getPath();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path + name));
            String mes = "";
            StringBuffer sb = new StringBuffer();
            sb.append(HspResponse.Header).append("\n");
            while ((mes = bufferedReader.readLine()) != null) {
                sb.append(mes).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            String mes = "";
            mes = HspResponse.Header + "<h1>404 改静态资源没有找到!!!<h1>";
            return mes;
        }
    }
}
