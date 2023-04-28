package com.hspedu.furns.test;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/4/28
 * @Description:
 */
public class HashMapClearThreadTest {

    @Test
    public void test() throws Exception {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.clear();
        System.out.println("map = " + map); // map = {}

    }
}
