package com.msb11;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/2 - 08 - 02
 * @Description: com.msb11
 */
public class Gril {
    // 加上privat 外界对他的访问就受到限制
    // 设置年龄
    private int age;
    // 空构造器
    public Gril () {

    }
    // 设置年龄
    public void  shezhiAge ( int age) {
        if (age >= 30) {
            this.age = 18;
        }else {
            this.age = age;
        }
    }
    // 读取年龄
    public int duquAge () {
        return age;
    }
}
