package Day13exer;


/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/3 - 09 - 03
 * @Description: Day13
 *
 *  练习：
 *  1.若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，
 *   系统将不可能把父类里的方法转移到子类中：编译看左边，运行看右边
 *
 *   2.对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，
 *   这个实例变量依然不可能覆盖父类中定义的实例变量：编译运行都看左边
 *
 *
 *  建立InstanceTest 类，在类中定义方法
 *    method(Person e);
 *    在method中:
 *    (1)根据e的类型调用相应类的getInfo()方法。
 *    (2)根据e的类型执行：
 *    如果e为Person类的对象，输出：
 *    “a person”;
 *    如果e为Student类的对象，输出：
 *    “a student”
 *    “a person ”
 *    如果e为Graduate类的对象，输出：
 *    “a graduated student”
 *    “a student”
 *    “a person”
 *
 *

 */
public class InstanceTest {
    public static void main(String[] args) {
        InstanceTest test = new InstanceTest();
        test.method(new Student());

    }

    public void method(Person e) {

        String info = e.getInfo();
        System.out.println(info);
        if (e instanceof Graduate) {
            System.out.println("a student" + "\n" + "a person" + "\n" + "a Graduate");
        } else if (e instanceof Student) {
            System.out.println("a student" + "\n" + "a person");

        }else {
            System.out.println("a person");
        }

    }

}

class Person {
    protected String name = "person";
    protected int age = 50;

    public String getInfo() {
        return "Name: " + name + "\n" + "age: " + age;
    }
}

class Student extends Person {
    protected String school = "pku";

    public String getInfo() {
        return "Name: " + name + "\nage: " + age
                + "\nschool: " + school;
    }
}

class Graduate extends Student {
    public String major = "IT";

    public String getInfo() {
        return "Name: " + name + "\nage: " + age + "\nschool: " + school + "\nmajor:" + major;
    }
}
