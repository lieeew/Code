package Day09;
import java.util.*;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/11 - 08 - 11
 * @Description: Day09
 */
public class ArraysUtil {

    // 数组冒泡排序
    public void  Sort (int[] arr) {
        for (int a = 0; a < arr.length; a++) {
            for (int j = 0; j < arr.length - 1 - a; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    // 最大值
    public int getMax (int[] arr) {
        Sort(arr);
        return arr[arr.length - 1];
    }
    // 最小值
    public int getSmall (int[] arr) {
        Sort(arr);
        return arr[0];
    }
    // 平均值
    public int getAverrage (int[] arr) {
        int sum = 0;
        for (int a = 0; a < arr.length; a++) {
            sum += arr[a];
        }
        return sum / arr.length;
    }
}
