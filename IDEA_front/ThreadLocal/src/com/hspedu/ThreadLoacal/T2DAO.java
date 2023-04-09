package com.hspedu.ThreadLoacal;

/**
 * @Author: qxy
 * @Date: 2023/4/9
 * @Description:
 */
public class T2DAO {

    public void update() {
        Object o = T1.threadLocal1.get();
        //获取当前线程的名称
        String name = Thread.currentThread().getName();
        System.out.println("T2DAO.update() 线程名 = " + name + " o = " + o);
    }
}
