package Day12.SecondTest;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/17 - 09 - 17
 * @Description: SecondTest
 */
public class a {
    public static void main(String[] args) {

        Person p = new Person();
        p.name = "lihuas";
        p.age = 10;

        MyTools tools = new MyTools();
        Person person = tools.copyPerson(p);
        System.out.println(person == p);


    }
}

class Person {

    String name;
    int age;
}
class MyTools {

    public Person copyPerson (Person k) {

        Person p2 = new Person();
        return p2;
    }
}
