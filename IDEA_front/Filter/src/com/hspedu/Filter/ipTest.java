package com.hspedu.Filter;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/3/24
 * @Description:
 */
public class ipTest {

    @Test
    public void test() {
        Pattern compile = Pattern.compile("128.13.\\d+.\\d+");
        Matcher matcher = compile.matcher("127.0.0.1");
        if (matcher.find()) {
            System.out.println("ok~~");
        } else {
            System.out.println("no~~");
        }

        String ip = "127.12";
        System.out.println("ip.substring(0, 3) = " + ip.substring(0, 3));
        System.out.println("ip.substring(4) = " + ip.substring(4));
    }

}
