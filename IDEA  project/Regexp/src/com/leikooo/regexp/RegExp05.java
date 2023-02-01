package com.leikooo.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/1 15
 * @Description:
 */
public class RegExp05 {
    public static void main(String[] args) {
        String content = "a211111aaaa1aahello";
        // String regStr = "a{3}"; // 匹配aaa
        // String regStr = "1{4}"; // 匹配 1111
        // String regStr = "\\d{2}"; // 匹配两位任意数字字符

        //a{3,4},1{4,5},\\d{2,5}
        //细节：java 匹配默认贪婪匹配，即尽可能匹配多的
        // String regStr = "a{3,4}"; // 匹配 aaa 或 aaaa
        // String regStr = "1{1,4}"; // 匹配 1 or 11 or 111 or 1111
        // String regStr = "\\d{2,5}"; // 匹配两位数或者三位数或者四位数

        // 1+
        // String regStr = "1+"; // 匹配一个1或者多个1
        // String regStr = "a+"; // 匹配一个a或者多个a
        // String regStr = "\\d+"; // 匹配一个num或者多个nums  结果211111

        //1*
        // String regStr = "a*"; // 匹配0个a 或者多个a
        // String regStr = "1*"; // 匹配0个1 或者多个1

        // ? 表示 0 或 1
        String regStr = "a1?"; // 匹配a or a1

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
