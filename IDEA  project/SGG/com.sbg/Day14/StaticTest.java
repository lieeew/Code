package Day14;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/8 - 09 - 08
 * @Description: Day14
 */
public class StaticTest {
    public static void main(String[] args) {

        Chinese.nation = "wuhu";
        Chinese c1 = new Chinese();
        c1.age = 14;
        c1.name = "lihua";
        c1.nation = "China";
        Chinese c2 = new Chinese();
        c2.age = 18;
        c2.name = "meimie";
        c2.nation = "CHN";
        System.out.println(c2.nation);

    }
}
class Chinese {
    String name;
    int age;
    static String nation;

}