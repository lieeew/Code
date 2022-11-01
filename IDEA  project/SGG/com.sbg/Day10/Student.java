package Day10;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/18 - 08 - 18
 * @Description: Day10
 */
public class Student {
    String name;
    int age;
    String school;
    String major;
    public Student () {

    }
    public Student (String n, int a) {
        name = n;
        age = a;
    }
    public Student (String n, int a, String s) {
        name = n;
        age = a;
        school = s;
    }
    public Student (String n, int a, String s, String m) {
        name = n;
        age = a;
        school = s;
        major = m;
    }
}
