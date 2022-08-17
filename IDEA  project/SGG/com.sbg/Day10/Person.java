package Day10;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/17 - 08 - 17
 * @Description: Day10
 */
public class Person {
    private int age;
    private String name;
    public Person () {
        age = 18;
    }
    public Person (String name, int age) {
        this.age = age;
        this.name = name;
    }
    public void setAge (int a) {
        if (a > 0 && a < 130) {
            age = a;
        }else {
            age = -1;
        }
    }
    public int getAge () {
        return age;
    }
    public void cheek (int a) {
        if (a == -1) {
            System.out.println("请录入正确的年龄");
        }else {
            System.out.println("年龄 :\t" + a);
        }
    }
    public void setAge1 (int a) {
        if (a < 0 || a > 130) {
            System.out.println("请录入正确的年龄");
            return; // 结束这个方法
        }
        age = a;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getName () {
        return name;
    }
}
