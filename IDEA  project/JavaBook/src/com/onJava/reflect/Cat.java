package com.onJava.reflect;

/**
 * @Author: qxy
 * @Date: 2023/2/27
 * @Description:
 */
public class Cat {

    public Cat() {
    }

    public void hi() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            stringBuffer.append(" ").append(i);
        }
    }
}
