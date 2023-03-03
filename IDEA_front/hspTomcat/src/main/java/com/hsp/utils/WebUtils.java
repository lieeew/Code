package com.hsp.utils;

/**
 * @Author: qxy
 * @Date: 2023/2/24
 * @Description:
 */
public class WebUtils {

    public static int parseInt(String num, int defaults) {
        int i = defaults;
        try {
            i = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            System.out.println("请输入正确的格式~~~");
        }
        return i;
    }
}
