package com.leikoooo.charpter16_slide;

import org.junit.jupiter.api.Test;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double widowSum = 0;
        if (k > nums.length || nums.length < 1 || k < 1) {
            return 0;
        }
        // 定义两个指针
        double maxValue = Integer.MIN_VALUE;
        for (int l = 0, r = k - 1; r < len; l++, r++) {
            for (int i = l; i < k + l; i++) {
                widowSum += nums[i];
            }
            maxValue = Math.max(widowSum, maxValue);
            widowSum = 0;
        }
        return maxValue / k;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        findMaxAverage(nums, 4);
    }
}