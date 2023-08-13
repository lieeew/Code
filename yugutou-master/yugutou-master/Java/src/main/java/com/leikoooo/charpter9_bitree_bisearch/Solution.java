package com.leikoooo.charpter9_bitree_bisearch;

import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 2, 2, 3, 3, 3, 4, 5, 6};
        int i = binarySearchLeftmost(arr, 3);
        System.out.println("i = " + i);
    }

    public int binarySearchLeftmost(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
