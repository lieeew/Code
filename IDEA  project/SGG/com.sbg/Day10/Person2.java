package Day10;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/19 - 08 - 19
 * @Description: Day10
 */
public class Person2 {
    int age;
    String name;
    public  Person2 () {

    }
    public  Person2 (int age) {
        this.age = age;
    }
    public Person2 (int age, String name) {
        this(age);// 必须写在前面
        this.name = name;
        // this.age = age;
    }

    public void eat () {
        System.out.println("吃饭");
    }
    public void play () {
        System.out.println("玩游戏");
    }
    public void things () {
        this.eat();
        this.play();
    }
}
