package com.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/2/4 11
 * @Description:
 */
public class NameList {
    private List names = new ArrayList();

    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized void printAll() {
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + "");
        }
    }

    public static void main(String[] args) {
        final NameList sl = new NameList();
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    sl.add("A");
                    sl.add("B");
                    sl.add("C");
                    sl.printAll();
                }
            }.start();
        }
    }
}

