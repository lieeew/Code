package com.leikooo.Matcher;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/2 22
 * @Description:
 */
public class RegTest {

    @Test
    public void test() {
        String content = "我....我要....学学学学....编程 java!";
        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        // 1. 去掉.
        content = matcher.replaceAll("");
        System.out.println("content = " + content);
        // 2. 去掉重复的汉字
        // 使用到了反向引用
        pattern = Pattern.compile("(.)\\1+");
        String s = pattern.matcher(content).replaceAll("$1");
        System.out.println("s = " + s);
    }

    @Test
    public void test2() {
        String content = "1331";
        // Pattern compile = Pattern.compile("(\\d)\\1");// 两位连续相同数字
        // Pattern compile = Pattern.compile("(\\d)\\1{4}"); // 连续5个相同的数字
        Pattern compile = Pattern.compile("(\\d)(\\d)\\2\\1"); // 个位千位 十位和百位相同
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println("success");
        }
    }
}
