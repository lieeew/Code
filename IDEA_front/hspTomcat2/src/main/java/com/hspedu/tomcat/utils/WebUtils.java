package com.hspedu.tomcat.utils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class WebUtils {

    //将字符串转成数字方法
    public static int parseInt(String strNum, int defaultVal) {
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            System.out.println(strNum + " 不能转成数字");
        }
        return defaultVal;
    }

    //判断uri是不是html文件
    public static boolean isHtml(String uri) {

        return uri.endsWith(".html");
    }

    //根据文件名来读取该文件->String
    public static String readHtml(String filename) {
        String path = com.hspedu.utils.WebUtils.class.getResource("/").getPath();
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path + filename));
            String buf = "";
            while ((buf = bufferedReader.readLine()) != null) {
                stringBuilder.append(buf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
