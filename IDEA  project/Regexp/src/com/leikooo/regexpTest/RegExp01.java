package com.leikooo.regexpTest;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/2 11
 * @Description:
 */
public class RegExp01 {
    @Test
    public void test1() {
        // 字母
        String content = "韩顺平教育";
        String regStr = "^[\\u0391-\\uffe5]+$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }

    @Test
    public void test2() {
        // 邮政编码
        // 要求：1.是 1-9 开头的一个六位数. 比如：123890
        String content = "121212";
        String regStr = "^[1-9]\\d{5}$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }

    @Test
    public void test3() {
        // QQ 号码
        // 要求: 是 1-9 开头的一个(5 位数-10 位数) 比如: 12389 , 1345687
        String content = "121212";
        String regStr = "^[1-9]\\d{4,9}$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }

    @Test
    public void test4() {
        // 手机号码
        // 要求: 必须以 13,14,15,18 开头的 11 位数 , 比如 13588889999
        String content = "13121212122";
        String regStr = "^(1[3|4|5|8])\\d{9}$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
    }

}
