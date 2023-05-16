package com;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/3 - 08 - 03
 * @Description: com
 */
public class Test {
    public static void main(String[] args) {
        information i = new information();
        i.setAge(10);
        i.sexSex("qiugdsacux");
        i.sexName("邱");
        System.out.println(i.getSex() + "-----" + i.getName() +"------"+ i.getAge()) ;
        information i2 = new information(14,"丽丽","bwfciuwhel");
        System.out.println(i2.getSex() + "-----" + i2.getName() +"------"+ i2.getAge()) ;

    }
}
