package com.msb;

        import java.util.Arrays;

public class TestArray17 {
    public static void main (String[] arges) {
        int [] arr = new int [] {10,13,1,8,6,8,2,4};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);  // 此后数组已被遍历
        System.out.println("调整后的数组为:");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr,10));
        int [] arr4 = {15,16,95,16,2,8,3,16};
        Arrays.sort(arr4);
        System.out.println(Arrays.toString(arr));
        int [] arr2 = Arrays.copyOf(arr,4);
        System.out.println(Arrays.toString(arr2));
        int [] arr3 = Arrays.copyOfRange(arr,1,5);
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.equals(arr2,arr3));
        // equals
        int [] a = {1,2,3,4,5,6,7};
        int [] b = {1,2,4,3,5,6,7};
        System.out.println(Arrays.equals(a,b));
        if (a == b) {// 比较的是左右两侧的地址值,所以不相等.
            System.out.println("OK");
        }else {
            System.out.println("NO");
        }

    }
}
