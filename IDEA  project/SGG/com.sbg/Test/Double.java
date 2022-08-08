package Test;

import java.util.Arrays;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/8 - 08 - 08
 * @Description: Test
 */
public class Double {
    public static void main(String[] args) {
        // 冒泡排序
        int[] arr = new int[] {34,5,22,-98,6,-76,0,-3};
        for (int i = 0; i <arr.length - 1; i ++) {
            for (int a = 0; a < arr.length - 1 - i; a ++) {
                if (arr[a] > arr[a + 1]) {
                    int b = arr[a];
                    arr[a] = arr[a + 1];
                    arr[a + 1] = b;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
