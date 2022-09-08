package Day14;

import java.util.Arrays;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/8 - 09 - 08
 * @Description: Day14
 */
public class ArrayUtil {
    public static void findMaxNum (int[] arr ) {
        int MaxNum = arr[0];
        for (int a = 0; a < arr.length; a ++) {
            if (MaxNum < arr[a]) {
                MaxNum = arr[a];
            }
        }
    }

    public static void sort (int[] arr) {
        for (int a = 0; a < arr.length - 1; a ++) {
            for (int j = 0; j <arr.length - 1 - a; j++) {
                if (arr[j] > arr[j + 1]) {
                    int num = arr[j];
                    arr[j] = arr[ j + 1];
                    arr[j + 1] = num;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
