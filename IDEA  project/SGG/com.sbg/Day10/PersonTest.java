package Day10;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/17 - 08 - 17
 * @Description: Day10
 */
public class PersonTest {
    public static void main(String[] args) {
        Person b = new Person();
        b.setAge(22222);
        b.cheek(b.getAge());
        Person b2 = new Person("TOM",12);
        System.out.println("name :" + b2.getName() + ",age :" + b2.getAge());
    }
}
