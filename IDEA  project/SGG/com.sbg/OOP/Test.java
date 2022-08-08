package OOP;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/8 - 08 - 08
 * @Description: OOP
 */
public class Test {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 13;
        Person p2 = p1;
        p2.age = 15;
        System.out.println(p1.age);
    }
}
