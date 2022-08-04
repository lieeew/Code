package com.msb.test01;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/3 - 08 - 03
 * @Description: com.msb.test01
 */
public class Test {
    // 程序入口
    public static void main(String[] args) {
        // 创建子类student的对象
        Student s = new Student ();
        s.setSno(499);
        s.getSno();
        s.study();
        s.setAge(19);
        s.setName("lili");
        s.setSex("男");
        System.out.println(s.getSex() + "---------" + s.getSno()+"------" + s.getName() + "--------"+ s.getAge());



    }
}
