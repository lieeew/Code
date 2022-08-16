package Day09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/16 - 08 - 16
 * @Description: Day09
 */
public class RecursionTest {
    public static void main(String[] args) {
        int sum = 0;
        for (int a = 0; a <= 100; a ++) {
            sum += a;
        }
        System.out.println(sum);
        RecursionTest test = new RecursionTest();
        int sum1 = test.getSum(100);
        System.out.println(sum1);
        // 计算乘积
        int Product = 1;
        for (int a = 1; a <= 10; a ++) {
            Product *= a;
        }
        System.out.println(Product);
        int Product1 = test.getProduct(10);
        System.out.println(Product1);
        //例3：已知一个数列：f(0) = 1,f(1) = 4,f(n+2)=2*f(n+1) + f(n),
        //其中n是大于0的整数，求f(10)的值。
        System.out.println(test.f(10));

    }
    // 计算0到100的和
    public int getSum (int a) {
        if (a == 1) {
            return 1;
        }else {
            return a + getSum(a - 1); // 递归
        }
    }
    // 例2：计算1-n之间所自然数的乘积:n!
    public int getProduct (int a) {
        if (a == 1) {
            return 1;
        }else {
            return a * getProduct(a - 1);
        }
    }
    public int f (int a) {
        if (a == 0) {
            return 1;
        }else if (a == 1) {
            return 4;
        }else {
            return 2*f(a - 1) + f(a - 2);
        }
    }
}
