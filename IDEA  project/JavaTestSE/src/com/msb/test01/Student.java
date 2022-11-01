package com.msb.test01;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/3 - 08 - 03
 * @Description: com.msb.test01
 */

    public class Student extends Person {// 继承Person
        private int sno; // 学号

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }
    // 方法
    public void study () {
        System.out.println("我喜欢学习");
    }
}

