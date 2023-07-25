package com.leikoooo.charpter3_array.level1.leetCode;

import org.junit.jupiter.api.Test;

/**
 * @author leikooo
 * @create 2023-07-25 22:26
 * @Package com.leikoooo.charpter3_array.level1.leetCode
 * @Description leetcode27 题目
 */
public class removeElements {
    @Test
    public void test1() {
        int[] nums = {2, 1, 2, 2, 3, 0, 4, 2};
        removeElement(nums, 2);
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }


}
