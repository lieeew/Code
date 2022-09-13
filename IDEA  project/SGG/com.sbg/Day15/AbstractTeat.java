package Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/13 - 09 - 13
 * @Description: Day15
 */
public class AbstractTeat {
    public static void main(String[] args) {
        College college = new College();
        college.eat();
    }
}
abstract class Person {

    String name;
    int age;

    public Person () {}

    public abstract void eat ();
}

abstract class Student extends Person {


    @Override
    public void eat() {
        System.out.println("healthy food");
    }
}
class College extends Student {

}