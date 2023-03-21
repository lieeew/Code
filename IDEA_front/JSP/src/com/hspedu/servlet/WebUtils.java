package com.hspedu.servlet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/3/18
 * @Description:
 */
public class WebUtils {

    public static Double parseDouble(String num, int defaultNum) {
        Pattern pattern = Pattern.compile("^[+,-]{0,2}\\d+$");
        Matcher matcher = pattern.matcher(num);

        if (matcher.find()) {
            return Double.parseDouble(num);
        } else {
            return null;
        }
    }
}
