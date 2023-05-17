package Day12;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/31 - 08 - 31
 * @Description: Day12
 */
public class Student extends Person {
    public void eat() {
        System.out.println("干饭");
    }

    public void wolk(int distance) {
        System.out.println("我走过了" + distance + "公里");
        sleep();
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    public static void main(String[] args) {
        Student stu = new Student();
        stu.eat();
        stu.wolk(100);
    }

    public String infor() {
        System.out.println(":wwww");
        return null;
    }
}
