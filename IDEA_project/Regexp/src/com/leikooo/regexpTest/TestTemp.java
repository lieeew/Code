package com.leikooo.regexpTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/2 18
 * @Description:
 */
public class TestTemp {
    public static void main(String[] args) {
        String content = "abc 123 . ?";
        String regStr = "."; // 匹配除了\n之外的所有
        String regStr1 = "[.]"; // 匹配.本身
        Pattern compile = Pattern.compile(regStr1);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("find " + matcher.group(0));
        }
    }
}
