package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/4 - 09 - 04
 * @Description: Day13
 */
public class EqualsTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        System.out.println(i == j);
        char c1 = 10;
        System.out.println(c1 == i);
        boolean b = true;
        // System.out.println(b == i); //报错
        char c2 = 65;
        char c3 = 'A';
        System.out.println(c2 == c3); // true

        System.out.println(c2 == 65); //true
        Customer cus1 = new Customer(12,"tom");
        Customer cus2 = new Customer(12, "tom");
        System.out.println(cus1 == cus2); //false

        System.out.println("***********");

        String str1 = new String("atguigu");
        String str2 = new String("atguigu");
        System.out.println(str1.equals(str2)); // true
        System.out.println(cus1.equals(cus2)); // false

    }
}
