package com.leikooo.regexp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/2 10
 * @Description: 分组
 */
public class RegExp07 {
    @Test
    public void test1() {
        String content = "hanshunping s7789 nn1189han";
        // 非命名分组
        String regStr = "(\\d\\d)(\\d\\d)";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
            System.out.println("找到第一组 " + matcher.group(1));
            System.out.println("找到第二组 " + matcher.group(2));
        }
    }
    @Test
    public void test2() {
        String content = "hanshunping s7789 nn1189han";
        // 命名分组
        String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
            System.out.println("找到第一组 " + matcher.group(1));
            System.out.println("找到第一组[名称] " + matcher.group("g1"));
            System.out.println("找到第二组 " + matcher.group(2));
            System.out.println("找到第二组[名称] " + matcher.group("g2"));
        }
    }
}
