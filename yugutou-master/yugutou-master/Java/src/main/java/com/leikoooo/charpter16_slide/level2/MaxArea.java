package com.leikoooo.charpter16_slide.level2;

public class MaxArea {
    public static void main(String[] args) {
//        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] nums = {1, 1};
        System.out.println(maxArea(nums));
    }

//    public static int maxArea(int[] height) {
//        int i = 0, j = height.length - 1, res = 0;
//        while (i < j) {
//            res = height[i] < height[j] ?
//                    Math.max(res, (j - i) * height[i++]) :
//                    Math.max(res, (j - i) * height[j--]);
//        }
//        return res;
//    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int result = 0;

        while (right < left) {
            result = height[left] < height[right] ? Math.max(result , (right - left) * Math.min(height[left++], height[right])) : Math.max(result, (right - left) * Math.min(height[left], height[right--]));
        }
        return result;
    }
}
