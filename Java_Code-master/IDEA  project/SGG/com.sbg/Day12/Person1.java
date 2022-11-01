package Day12;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/31 - 08 - 31
 * @Description: Day12
 */
public class Person1 {
    String name;
    int age;
    int id = 1002; // 身份证号
    public Person1 () {

    }
    public Person1 (String name) {

        this.name = name;
    }
    public Person1 (String name, int age) {
        this (name);
        this.age = age;

    }
    public void eat () {
        System.out.println("吃东西");
    }
    public void study () {
        System.out.println("学习");
    }
}
