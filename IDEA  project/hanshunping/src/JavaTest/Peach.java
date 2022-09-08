package JavaTest;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/22 - 08 - 22
 * @Description: Test
 */
public class Peach {
    public static void main(String[] args) {
        int sum =0;
        int amt = 1;
        for (int a = 1; a <= 9; a++) {
            sum = (1 + amt) * 2 ;
            amt = sum;
        }
        System.out.println("桃子的总数为:" + sum);
    }
}
