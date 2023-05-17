package Day12;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/1 - 09 - 01
 * @Description: Day12
 */
public class AccountTest {
    public static void main(String[] args) {
        CheckAccount ch = new CheckAccount(1122, 20000, 0.045,5000);
        ch.withdraw(5000);
        ch.withdraw(18000);
        ch.withdraw(2000);


    }
}
