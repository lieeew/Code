package Day12;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/31 - 08 - 31
 * @Description: Day12
 */
public class Student1 extends Person1{
    String major;
    int id = 1001; // 学号
    public Student1 () {

    }
    public Student1 (String major, int age, String name) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void eat() {
        System.out.println("学生,多吃营养餐");
    }

    @Override
    public void study() {
        System.out.println("学生, 学习知识");
        System.out.println(this.id);
        System.out.println("*****************");
        System.out.println(super.id);
        this.eat();
        super.eat();
    }
    public void show () {
        System.out.println("name :" + this.name + ", age :" + this.age ); // 可以省略this
    }
}
