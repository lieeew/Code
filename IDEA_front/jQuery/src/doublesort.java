/**
 * @Author: qxy
 * @Date: 2023/3/27
 * @Description:
 */
public class doublesort {
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 冒泡排序
        int[] arr = {10, 30, 8, 4, 90, 50, 70, 100, 80};
        print(arr);
        sort(arr);
        print(arr);

    }

    public static void sort(int[] arr) {
        /*
        0  N
        0  n-1
        0  n-2
        0  n-3
        0  n-4
        0  i
         */
        int N = arr.length;
        for (int i = N; i >= 1; i--) {
            /*
            0 - 1
            1 - 2
            2 - 3
            3 - 4
            4 - 5
            N-1 N
             */
            for (int j = 0; j < N - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
            }

        }
    }
}
