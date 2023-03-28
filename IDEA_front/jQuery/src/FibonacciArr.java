/**
 * @Author: qxy
 * @Date: 2023/3/27
 * @Description:
 */
public class FibonacciArr {
    public static void main(String[] args) {
        long[] arr = new long[100];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < 100; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(arr[i] + "\t");
        }
    }
}
