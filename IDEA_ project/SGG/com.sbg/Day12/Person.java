package Day12;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/31 - 08 - 31
 * @Description: Day12
 */
public class Person {
    String name;
    int age;
    String infor;
    public  Person () {

    }
    public  Person (String name, int age) {
        this.age = age;
        this.name = name;
    }
    public void eat () {
        System.out.println("eat");
    }
    public void Study () {
        System.out.println("study");
        sleep();
    }
    private void sleep () {
        System.out.println("睡觉");
    }
    public Object infor () {
        return infor;
    }
}
