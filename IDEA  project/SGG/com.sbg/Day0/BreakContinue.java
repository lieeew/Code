package Day0;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/14 - 09 - 14
 * @Description: Day0
 */

/**
 * continue 结束当次循环
 * break 结束当前循环
 */
public class BreakContinue {
    public static void main(String[] args) {

        for (int a = 0; a < 10; a++) {
            if (a % 4 ==0) {
                continue;
            }
            System.out.print(a); // 1235679
        }
    }
}
