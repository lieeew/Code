package com.msb;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/29 - 07 - 29
 * @Description: com.msb
 */
public class student {
    String name;
    int age;
    int StudyTime;
    double a;
    float b;
    boolean c;
    long d;
    short e;
    char f;
    public void eat () {
        int num;
    }
    public void drink () {
        System.out.println("雪碧");
    }

    public static void main(String[] args) {
        student ls = new student();
        System.out.println(ls.age);
        System.out.println(ls.name);
        System.out.println(ls.StudyTime);
        System.out.println(ls.a);
        System.out.println(ls.b);
        System.out.println(ls.c);
        System.out.println(ls.d);
        System.out.println(ls.e);
        System.out.println(ls.f);

    }
}
