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


    }
}
