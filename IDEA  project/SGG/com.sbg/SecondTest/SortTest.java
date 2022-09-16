package SecondTest;

import java.util.Arrays;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/14 - 09 - 14
 * @Description: SecondTest
 */
public class SortTest {
    public static void main(String[] args) {
        int [] arr = {1,60,48,90};
        sort sort = new sort();
        sort.operate(arr);


    }
}


class sort {

    public void operate (int[] arr) {
        for (int a = 0; a < arr.length; a++) {
            for (int j = 0; j < arr.length - 1 -a; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}