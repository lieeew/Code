package Day10;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/17 - 08 - 17
 * @Description: Day10
 */
public class PersonTest02 {
    /* 1.如果没显式的定义类的构造器的话，则系统默认提供一个空参的构造器
 * 2.定义构造器的格式：权限修饰符  类名(形参列表){}
 * 3.一个类中定义的多个构造器，彼此构成重载
 * 4.一旦我们显式的定义了类的构造器之后，系统就不再提供默认的空参构造器
 * 5.一个类中，至少会有一个构造器。*/
    public static void main(String[] args) {
        // 创建类的对象  new + 构造器
        Person1 p = new Person1();
        Person1 p1 = new Person1("tom");
        System.out.println(p1.naem);



    }
}
class Person1 {
    // 属性
    String naem;
    int age;
    // 构造器
    public Person1 () {

    }
    public Person1 (String name) {
        this.naem = name;
    }
    // 方法
    public void eat () {
        System.out.println("干饭");
    }

}