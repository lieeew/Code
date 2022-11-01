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
        for (int a = 0; a < arr.length - 1; a++) {
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
    public int getMax01 (int[] arr) {
        Sort(arr);// 调这个方法也打印arr数组
        return arr[arr.length - 1];
    }
    // 最小值
    public int getSmall01 (int[] arr) {
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
    // 求最大值
    public int getMax (int[] arr) {
        int MaxNum = arr[0];
        for (int a =0; a < arr.length; a++) {
            if (arr[a] > MaxNum) {
                MaxNum = arr[a];
            }
        }
        return MaxNum;
    }
    // 求最小值
    public int getMine (int[] arr) {
        int MineNum = arr[0];
        for (int a = 0; a < arr.length; a++ ) {
            if (arr[a] < MineNum) {
                MineNum = arr[a];
            }
        }
        return MineNum;
    }
    // 求总和
    public int sum (int[] arr) {
        int sum = 0;
        for (int a = 0; a < arr.length; a++) {
            sum += arr[a];
        }
        return sum;
    }
    // 数组的复制
    public void copy (int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int a =0; a < arr.length; a++) {
            arr2[a] = arr[a];
        }
        System.out.println(Arrays.toString(arr2));
    }
    // 翻转数组
    public void reverse (int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int a = 0; a < arr.length; a++) {
            arr2[a] = arr[arr.length - a - 1];
        }
        System.out.println(Arrays.toString(arr2));
    }
    // 查找数组中的指定元素
    public int getNum (int[] arr, int num) {
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == num) {
                return a;
            }
        }
        return -1; // 需要接收
    }
}
