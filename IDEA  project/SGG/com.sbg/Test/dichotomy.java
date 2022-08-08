package Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/8 - 08 - 08
 * @Description: Test
 */
public class dichotomy {
    public static int Find (int[] arr,int num) {
        int head = 0;
        int end = arr.length - 1;
        while (end >= head) {
            int middle = (head + end) / 2;
                if (arr[middle] > num) {
                    end = middle - 1;
                }else if (arr[middle] == num) {
                    return middle;
                }else {
                    head = middle + 1;
                }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 9, 78, 90, 167};
        System.out.println(Find(arr,16));
    }
}
