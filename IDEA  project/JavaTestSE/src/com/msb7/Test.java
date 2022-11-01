package com.msb7;

import com.msb2.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/1 - 08 - 01
 * @Description: com.msb7
 */
public class Test {
    public static void main(String[] args) {
        // 包的作用是为了解决重名问题
        new Person();
        new Date();
        new java.sql.Date(1000L);
        System.out.println(Math.random());
        new ArrayList<>();
        new HashMap<>();

    }
}
