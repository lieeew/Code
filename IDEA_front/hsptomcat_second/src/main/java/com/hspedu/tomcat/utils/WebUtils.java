package com.hspedu.tomcat.utils;

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
}
