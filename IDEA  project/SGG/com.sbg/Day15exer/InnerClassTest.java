package Day15exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/19 - 09 - 19
 * @Description: Day15exer
 */

/**
 * 内部类
 *
 * 1. java允一个类A , 声明在另一个类B中, 类A叫做内部类
 * 2. 位置: 成员内部类(静态和非静态) vs 局部内部类 (构造器, 代码块, 方法)
 * 3.
 */
public class InnerClassTest {
    public static void main(String[] args) {

        Person p = new Person();
        Person.Bird bird = p.new Bird();
        bird.print("我输入的");
    }
}

class Person {

    String name = "人";
    // 静态内部类
    static class Dog {
        String name;
        int age;
        public void Call () {
            System.out.println("汪汪汪");
        }

    }

    public void eat() {
        System.out.println("干饭");
    }
    // 非静态内部类
    class Bird {
        String name = "黄鹂";
        int age;
        public void Sing () {
            System.out.println("我是一个小小鸟");
            Person.this.eat();
        }

        public void print (String name) {
            System.out.println(name);
            System.out.println(Person.this.name);
            System.out.println(this.name);
        }

    }

    public Person() {
        // 局部内部类
        class BB {

        }
    }

    {// 局部内部类
        class CC{

        }
    }

    public void method () {
        // 局部内部类
        class AA {

        }
    }
}