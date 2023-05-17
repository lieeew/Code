package Day12Exercise.Day12Polymorphism;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/1 - 09 - 01
 * @Description: Day12Polymorphism
 */
public class PersonTest {
    public static void main(String[] args) {
        Man p1 = new Man();
        p1.age = 18;
        p1.eat();
        p1.walk();
        p1.earnMoney();
        System.out.println("*************");
        // 多态性
        Person p2 = new Man();
        p2.eat();


    }
}
