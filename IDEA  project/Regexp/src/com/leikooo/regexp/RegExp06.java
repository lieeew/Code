package com.leikooo.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/1 17
 * @Description: 演示定位符
 */
public class RegExp06 {
    public static void main(String[] args) {
        String content =  "0hanshunping sphan nnhan";
        // String content = "123-az";
        // 以一個0到9開頭, 包括a-z之间, 0个或多个 中间使用-进行连接
        // String regStr = "^[0-9]+\\-[a-z]*";

        // String regStr = "han\\b"; // 以han为边界, 这里的边界是值字符串的最后, 或者是空格子串的后面
        String regStr = "[a-z]$"; //字符串的最后面
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
     }
}
