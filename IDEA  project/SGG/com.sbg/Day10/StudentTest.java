package Day10;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/18 - 08 - 18
 * @Description: Day10
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student("tom", 2, "^_^", "dd");
        System.out.println(s.age + "\n" + s.name + "\n" + s.school + "\n" + s.major);
    }
}
