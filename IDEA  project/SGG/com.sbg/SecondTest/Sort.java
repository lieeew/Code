package SecondTest;

import java.util.Arrays;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/20 - 09 - 20
 * @Description: SecondTest
 */
public class Sort {
    public static void main(String[] args) {

//        int[] arr = {1, 3, 90, 4, 6, 40};
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.doubblesort(arr);

    }
}


class BubbleSort {

    public void doubblesort (int[] arr) {
        for (int a = 0; a < arr.length - 1; a++) {
            for (int j = 0; j < arr.length - a - 1; j++) {
                if (arr[j] > arr[j + 1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

