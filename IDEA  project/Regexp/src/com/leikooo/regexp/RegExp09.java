package com.leikooo.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/2 11
 * @Description: ?非贪婪匹配
 */
public class RegExp09 {
    public static void main(String[] args) {
        String content = "abc1111";
        String regStr = "\\d+?";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("find " + matcher.group(0));
        }
    }
}
