package com.leikoooo.charpter5_queue_map.level2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // 暴力破解
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("can not found this index");
    }

    //第二种实现方式
    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>(len - 1);
        for (int i = 0; i < len; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(temp), i};
            }
            hashMap.put(nums[i], i);
        }
        throw new RuntimeException("can not found this index");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
    }
}
