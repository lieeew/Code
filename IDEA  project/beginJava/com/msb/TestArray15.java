package com.msb;
// 删除指定的值

        import java.util.Arrays;
        import java.util.Scanner;

public class TestArray15 {
    public static void main(String[] arges) {
        int index = -1;  // 创建一个值来存储序号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的数:");
        int input = sc.nextInt();
        int[] arr = {12, 95, 562,2,  6, 4, 45, 666, 2, 66, 2,};
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == input) {
                index = a;
                break;
            }
        }

        System.out.println("删除前:" + Arrays.toString(arr));  // 更改前的数组
        for (int a = index; a < arr.length - 1 ; a++) {
            arr[a] = arr[a + 1];
        }
        arr[arr.length - 1] = 0;
        System.out.println("更改后的数组为:" + Arrays.toString(arr));
    }
}

