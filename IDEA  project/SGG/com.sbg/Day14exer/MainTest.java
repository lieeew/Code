package Day14exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/9 - 09 - 09
 * @Description: Day14exer
 */

/**
 * main()方法
 * 1. 程序的入口
 * 2. main()方法也静态
 * 3.main() 方法可以作为和控制台交互
 */
public class MainTest {
    public static void main(String[] args) {
        Main.main(new int[100]);

    }
}

class Main {
    public static void main (int[] arr)  {
        for (int a = 0; a < arr.length; a ++) {
            arr[a] = a + 1;
            System.out.println(arr[a]);
        }
    }


}
