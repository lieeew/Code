package JavaTest;

import java.util.Arrays;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/8 - 08 - 08
 * @Description: Test
 */
public class fanzhuan {
    public static void main(String[] args) {
        int[] arr = new int[] {34,5,22,-98,6,-76,0,-3};
        int[] arr2 = new int[arr.length];
        for (int a = 0; a < arr.length; a++) {
            arr2[a] = arr[a];
        }
        System.out.println(Arrays.toString(arr2));
    }
}
