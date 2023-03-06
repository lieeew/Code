package com.hspedu.tomcat.utils;

import com.hspedu.HspTomcatV3;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/3/4
 * @Description:
 */
public class WebUtils {
    public static int parseInt(String strNum, int defaultVal) {
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            System.out.println(strNum + "不能转化为数字 ~~~");
        }
        return defaultVal;
    }

    /**
     * 判断时候是html页面
     */
    public static boolean isHtml(@NotNull String uri) {
        return uri.endsWith(".html");
    }

    /**
     * 返回静态界面资源, 者也可以放到request之中
     * @param fileName 文件的名字
     * @return 返回值是文件内容
     */
    @NotNull
    public static String readHtml(String fileName) {
        String path = HspTomcatV3.class.getResource("/").getPath();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path + fileName.substring(1)));
            StringBuffer sb = new StringBuffer();
            String mes = "";
            while ((mes = bufferedReader.readLine()) != null) {
                if (mes.length() == 0) {
                    break;
                }
                sb.append(mes);
            }
            return sb.toString();

        } catch (IOException e) {
            return "<h1>404 NOT FOUND 没有找到该文件<h1>";
        }
    }
}
