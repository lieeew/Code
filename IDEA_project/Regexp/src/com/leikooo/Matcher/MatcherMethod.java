package com.leikooo.Matcher;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/2 20
 * @Description:
 */
public class MatcherMethod {
    @Test
    public void test1() {
        String content = "hello edu tom hello smith hello";
        String regStr = "hello";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("=========");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println(content.substring(matcher.start(), matcher.end()));
        }
    }

    @Test
    public void test2() {
        String content = "hello edu tom hspedu smith hello hspedu hspedu";
        String regStr = "hspedu";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        String replaceAll = matcher.replaceAll("韩顺平教育");
        System.out.println("replaceAll = " + replaceAll); // replaceAll = hello edu tom 韩顺平教育 smith hello 韩顺平教育 韩顺平教育
    }
}

