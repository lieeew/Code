package Day30exer;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/25 - 11 - 25
 * @Description: Day30exer
 */
@MyAnnotation
public class Person extends Creature<String> implements MyInterface , Comparable<String>{

    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation
    public Person(String name) {
        this.name = name;
    }

    @MyAnnotation("hi")
    Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation("abc")
    private String show(String nation) {
        System.out.println("我的国籍是 : " + nation);
        return nation;
    }

    public String display(String interests, int age)  {
        return interests;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    public static void showDest(int id, double weight) {
        System.out.println("我是静态方法");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
