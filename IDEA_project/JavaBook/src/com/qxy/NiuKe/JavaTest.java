package com.qxy.NiuKe;

import org.junit.Test;

/**
 * @Author: qxy
 * @Date: 2023/2/4 16
 * @Description:
 */
public class JavaTest {
    public void change(StringBuffer sb) {
        sb.append("nb");
    }

    @Test
    public void test() {
        StringBuffer sb = new StringBuffer("abc");
        change(sb);
        System.out.println(sb);
    }
}
