package com.onJava.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: qxy
 * @Date: 2023/2/27
 * @Description:
 */
public class reflect {

    @Test
    public void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();

        System.out.println("花费时间 = " + (end - start));
    }

    @Test
    public void m2() {
        try {
            Class<?> aClass = Class.forName("com.onJava.reflect.Cat");
            Cat o = (Cat) aClass.newInstance();
            Method hi = aClass.getMethod("hi");

            long start = System.currentTimeMillis();

            for (int i = 0; i < 900000000; i++) {
                hi.invoke(o);
            }
            long end = System.currentTimeMillis();

            System.out.println("花费时间 = " + (end - start));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void m3()  {
        try {
            Class<?> aClass = Class.forName("com.onJava.reflect.Cat");
            Object o = aClass.newInstance();
            Method hi = aClass.getMethod("hi");
            hi.setAccessible(true);
            long start = System.currentTimeMillis();

            for (int i = 0; i < 900000000; i++) {
                hi.invoke(o);
            }
            long end = System.currentTimeMillis();
            System.out.println("花费时间 = " + (end - start)); // 花费时间 = 53
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
