package com.msb.Test06;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/4 - 08 - 04
 * @Description: com.msb.Test06
 */
public class Student extends Person {
    private String study;
    public Student eat () {
        System.out.println("我喜欢吃饭");
        return new  Student ();
    }

}
