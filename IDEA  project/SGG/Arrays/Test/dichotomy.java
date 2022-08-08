package Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/8 - 08 - 08
 * @Description: Test
 */
public class dichotomy {
    public int Find (int[] arr,int num) {
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



    }
}
