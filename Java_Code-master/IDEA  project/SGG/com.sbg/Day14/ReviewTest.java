package Day14;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/8 - 09 - 08
 * @Description: Day14
 */
public class ReviewTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4}; // 数组也是继承与object
        System.out.println(arr.toString());


        // 自己写的equals方法的缺陷
        Person p = new Person("tom", 14);
        Man m = new Man("tom", 14);
        System.out.println(m.equals(p));

    }

}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return ((Person) obj).age == this.age && ((Person) obj).name.equals(this.name);

        }
        return false;
    }
}
class Man extends Person {
    String name;
    int age;

    public Man(String name, int age) {
        super(name, age);
    }
}