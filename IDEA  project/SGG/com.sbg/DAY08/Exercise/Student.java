package DAY08.Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/9 - 08 - 09
 * @Description: DAY08.Exercise
 */
public class Student {
    String name;
    int age;
    int sex;
    public void study () {
        System.out.println("studtying");
    }
    public int addAge (int i) {
        age += i; // 谁调是谁的age
        return age;
    }
    public void showAge () {
        System.out.println("age = " + age);
    }
}
