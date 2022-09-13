package Day14exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/9 - 09 - 09
 * @Description: Day14exer
 */

/**
 * 静态代码块(初始化块)
 *  > 跟着类的加载而加载,而执行,且执行一次
 *  > 静态代码块执行优于非静态代码块
 *  > 作用 : 可以进行赋值操作,初始化类的信息,不能赋值非静态变量
 *
 *
 *  非静态
 *   > 随着对象的创建而创建
 *   > 每创建一个对象就执行一次
 *   > 作用: 可以在创建对象时,对对象属性进行赋值
 *
 *
 */
public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;

        Person p1 = new Person();
        System.out.println(p1.age + "\t" + p1.name);

        Person P2 = new Person();

        System.out.println(Person.desc);


    }
}

class Person {
    // 属性
    String name;
    int age;
    static String desc = "一坨人";
    // 构造器

    public Person() {
    }

    public Person (String name, int age) {
        this.age = age;
        this.name = name;

    }
    // 静态代码块
    static {
        System.out.println("hello block");
        desc = "头顶有风";
        // name = "lihua";
    }
    // 非静态代码块
    {
        System.out.println("why?");
        name = "lihua";
        age = 13;
    }


    @Override
    public String toString() { // 美化代码 Ctrl + Shift + J
        return "Person{name='" + name + '\'' + ", age=" + age + '}';
    }
}
