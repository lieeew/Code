package com.leikooo.regexp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/2 10
 * @Description: 非捕获封住
 */
public class RegExp08 {
    @Test
    public void test1() {
        String content = "hello 韩顺平教育 jack 韩顺平老师 韩顺平同学 hello 韩顺平学生";
        // 找到 韩顺平教育 、韩顺平老师、韩顺平同学 子字符串
        // String regStr = "韩顺平教育|韩顺平老师|韩顺平同学";
        // String regStr = "韩顺平(?:教育|老师|同学)";
        // String regStr = "韩顺平(?=教育|老师|同学)";
        String regStr = "韩顺平(?!教育|老师|同学)";// 相当于?:的取反
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(" find " + matcher.group(0));
        }
    }
}
