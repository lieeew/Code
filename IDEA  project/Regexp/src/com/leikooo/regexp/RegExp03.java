package com.leikooo.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/1 10
 * @Description:
 */
public class RegExp03 {
    public static void main(String[] args) {
        String content = "a11c8abc _ABCy @.";
        // String regStr = "[a-z]"; // 匹配a到z之间的任意一个小写字母
        // String regStr = "[A-Z]"; // 匹配A到Z之间的任意一个大写字母
        // String regStr = "abc"; // 默认区分大小写
        // String regStr = "(?i)abc"; // 不区分大小写
        // String regStr = "[0-9]"; // 0-9之间的字符 包括0和9
        // String regStr = "[^a-z]"; // 除了小写a到小写z的其他字符
        // String regStr = "[A-Z]{2}"; // [A-Z]{2}作用相当于两个[A-Z][A-Z]
        // String regStr = "[^A-Z]"; // 不是大些A-Z之间的其他字符
        // String regStr = "[abcd]"; // 匹配abcd之中的任意一个字符
        // String regStr = "[^abcd]"; // 匹配不是abcd之中的任意一个字符
        // String regStr = "[\\D]"; // 匹配不是0-9的任意一个字符
        // String regStr = "[\\w]"; // 匹配任意一个英文字符, 数字, 下划线  相当于[a-zA-Z0-9]
        // String regStr = "[\\W]"; // 匹配任意一个非英文字符, 数字, 下划线  相当于[^a-zA-Z0-9] 包括空格
        // String regStr = "[\\s]"; // 匹配任意空字符串(空格, 制表符)
        // String regStr = "[\\S]"; // 匹配非任意空字符串(空格, 制表符)
        // String regStr = "[.]"; // 匹配除了\n之外的全部字符
        String regStr = "[\\.]"; // 匹配 . 本身
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
