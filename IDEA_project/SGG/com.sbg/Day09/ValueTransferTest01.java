package Day09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/13 - 08 - 13
 * @Description: Day09
 */
public class ValueTransferTest01 {
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        System.out.println("m = " + m + ",n =" + n);
        // 交换二个值
        int temp = n;
        n = m;
        m = temp;
        System.out.println("m = " + m + ",n =" + n);
    }
}
