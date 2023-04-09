package com.hspedu.ThreadLoacal;

/**
 * @Author: qxy
 * @Date: 2023/4/9
 * @Description:
 */
public class T1Service {

    public void update(){
        Object o = T1.threadLocal1.get();
        // 获取当前的线程名称
        String name = Thread.currentThread().getName();
        System.out.println("T1Service的update 线程 = " + name + " o = ");
        new T2DAO().update();
    }
}
