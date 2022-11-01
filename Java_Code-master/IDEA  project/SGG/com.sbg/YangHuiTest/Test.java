package YangHuiTest;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/7 - 08 - 07
 * @Description: YangHuiTest
 */
public class Test {
    public static void main(String[] args) {
        // 1.定义一个二维数组
        int[] [] arr = new int[10] [10];
        // 2. 赋值
        for (int a = 0; a < arr.length; a ++) {
            for (int j = 0; j < a + 1; j ++) {
                if (j == 0 || j == a) {
                    arr[a][j] = 1;
                }else {
                    arr[a][j]=arr[a-1][j]+arr[a-1][j-1];
                }
                System.out.print(arr[a][j] + "\t");
            }
            System.out.println(  );
        }
    }
}
