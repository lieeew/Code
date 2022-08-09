package DAY08;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/9 - 08 - 09
 * @Description: DAY08
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.age = 18;
        System.out.println(c.age);

    }
}
class Customer { // 客户类
    String name;
    int age;
    boolean ismale;
    public Customer () {}
    public Customer (int age,String naem,Double weight) {}
    public void eat (String food) {
        System.out.println("客户和我一起吃" + food);
    }
    public int sleep (int hour) {
        System.out.println("睡" + hour + "小时");
        return age;
    }
    public String  name () {
        return name;
    }
    public String nation (String nation) {
        String infor = "我是" + nation + "国人";
        return infor;
    }
    public int sleep () {
        if(age > 18) {
        return age;
        }else {
            return age;
        }
    }

}