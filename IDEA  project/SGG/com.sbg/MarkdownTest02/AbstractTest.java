package MarkdownTest02;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/15 - 09 - 15
 * @Description: MarkdownTest02
 */
public class AbstractTest {
    public static void main(String[] args) {
        Person p = new Student();
        p.study();


    }
}

abstract class Person {

    public abstract void study ();
}

class Student extends Person {

    @Override
    public void study() {
        System.out.println("学生学习");
    }
}