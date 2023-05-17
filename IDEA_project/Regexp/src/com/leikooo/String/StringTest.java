package com.leikooo.String;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/3 09
 * @Description: string中使用正则表达式
 */
public class StringTest {

    @Test
    public void test1() {
        String content = "Java平台由Java虚拟机(Java Virtual Machine)和Java 应用编程接口" +
                "(Application Programming Interface、简称API)构成。Java 应用编程接口为Java" +
                "应用提供了一个独立于操作系统的标准接口，可分为基本部分和扩展部分。在硬件或操作系统平" +
                "台上安装一个Java平台之后，Java应用程序就可运行。Java平台已经嵌入了几乎所有的操作系统。这样Java程序可以只编译一次，" +
                "就可以在各种系统中运行。Java应用编程接口已经从1.1x版发展到1.2版。常用的Java平台基于Java1.8，最近版本为Java19。";
        String regStr = content.replaceAll("Java1\\.8|Java19", "Java");
        System.out.println("regStr = " + regStr);

    }

    @Test
    public void test2() {
        String content = "13911111111";
        /* 底层源码
            public boolean matches(String regex) {
                return Pattern.matches(regex, this);
            }
         */
        if (content.matches("^(138|139)\\d{8}")) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }

    }

    @Test
    public void test3() {
        String content = "hello#abc-jack12smith~北京";
        String[] strings = content.split("#|-|~|\\d+");
        for (String string : strings) {
            System.out.println(string);
        }
    }


    /**
     * 匹配邮箱
     */
    @Test
    public void test4() {
        /*
        nb. 对应 [a-zA-Z_-]+\.
        com  对应 [a-zA-Z]+
         */
        String content = "10086@nb.com";
        String regStr = "^[\\w-]+@([a-zA-Z_-]+\\.)+[a-zA-Z]+$"; // 使用整体匹配那么就不需要使用 ^ ?
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }

    /**
     * 判断邮箱
     */
    @Test
    public void test5() {
        String content = "10086@nb.com";
        if (Pattern.matches("[\\w-]+@([a-zA-Z-]+\\.)+[a-zA-Z]+", content)) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }

    /**
     * 判断小数或者整数
     */
    @Test
    public void test6() {
        String content = "+0.9";
        if (Pattern.matches("^[-+]?[\\d*|0]\\.?[0-9]+$", content)) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }

    /**
     * 分组
     */
    @Test
    public void test7() {
        String content = "http://www.sohu.com:8080/abc/idex.htm";
        Pattern compile = Pattern.compile("^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)/[\\w-/]*/(\\w.+)$");
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println("find " + matcher.group(0));
            System.out.println("协议 " + matcher.group(1));
            System.out.println("域名 " + matcher.group(2));
            System.out.println("端口 " + matcher.group(3));
            System.out.println("文件 " + matcher.group(4));
        } else {
            System.out.println("failure");
        }
    }

}
