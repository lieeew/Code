package DAY08.Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/9 - 08 - 09
 * @Description: DAY08.Exercise
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.age = 18;
        s1.name = "lili";
        s1.sex = 2;
        System.out.println(s1.addAge(2));
        System.out.println("age:" + s1.age + "岁" );
        Student s2 = new Student();
        System.out.println(s2.age);
        s2.addAge(3);
        System.out.println(s2.age); // 2
        System.out.println(s1.age); // 20
    }
}
