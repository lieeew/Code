package Day13exer.MarkDown;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/9 - 09 - 09
 * @Description: MarkDown
 */
public class BlockTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

    }
}
class Person {

    String name;
    int age;

    {
        System.out.println("静态代码块");
    }

}
