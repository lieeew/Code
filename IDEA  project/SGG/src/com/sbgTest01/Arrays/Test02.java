package com.sbgTest01.Arrays;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/5 - 08 - 05
 * @Description: com.sbgTest01.Arrays
 */
public class Test02 {
    public static void main(String[] args) {
        // 二分法前提有序
        int[] num  = {2, 3, 5, 7, 9, 78, 90, 167};
        boolean isflage = true;
        int dest = 3;
        int head = 0;
        int end = num.length - 1;
        while (end >= head) {
            int middle =( head + end ) / 2;
            if (dest == num[middle]) {
                System.out.println("你要查询的数为:" + middle);
                isflage = false;
                break;
            }else if (dest > num[middle]) {
                head = middle + 1;
            }else  {
                head = middle - 1;
            }
        }
        if (isflage) {
            System.out.println("查无此数");
        }
    }
}
