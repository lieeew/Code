package Day13;



/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/1 - 09 - 01
 * @Description: Day12Polymorphism
 */
public class PersonTest {
    public static void main(String[] args) {
        Man p1 = new Man();
        p1.age = 18;
        p1.eat();
        p1.walk();
        p1.earnMoney();
        System.out.println("*************");
        // 多态性
        Person p2 = new Man();
        p2.eat();
        // p2.earnMoney(); 不能调用earnMoney这个方法,因为p2是person 类型的.
        // p2.isSmoking = true;
        System.out.println("***************");

        //如何调用子类特有的方法
        Man m1 = (Man)p2;
        m1.isSmoking = true;
        m1.earnMoney();
   /*     // 编译通过,运行不过 ClassCastException
        // 举例一
        Person p3 = new Man();
        Women w2 = (Women) p3;
        // 举例二   ClassCastException
        Person p4 = new Person();
        Man m4 = (Man)p4;
        m4.earnMoney();

        // 编译通过,运行也通过
        Object obj = new Man();
        Person p5 = (Person) obj;

        // 编译不通过
        // Mam m5 = new Womem();
        */


        System.out.println("*********");
        PersonTest test = new PersonTest();
        test.watchDoor(new Women());

    }
    public void watchDoor (Person p) {
        if (p instanceof Women) {
            Women W1 = (Women) p;
            W1.goShopping();
        }
    }
}
