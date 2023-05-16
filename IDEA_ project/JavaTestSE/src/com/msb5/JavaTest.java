package com.msb5;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/30 - 07 - 30
 * @Description: com.msb5
 */
public class JavaTest {
    int id;
    static int iid;
    // 程序的入口
    public static void main(String[] args){
        JavaTest p1 = new JavaTest();
        p1.id = 10;
        p1.iid = 20;
        JavaTest p2 = new JavaTest();
        p2.id = 30;
        p2.iid = 30;
        JavaTest p3 = new JavaTest();
        p3.id = 40;
        p3.iid = 40;
        System.out.println(p1.id);
        System.out.println(p1.iid);
        System.out.println(p2.id);
        System.out.println(p2.iid);
        System.out.println(p3.id);
        System.out.println(p3.iid);

    }

}
