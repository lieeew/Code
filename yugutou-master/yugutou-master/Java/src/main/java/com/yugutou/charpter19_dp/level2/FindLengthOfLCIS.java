package com.yugutou.charpter19_dp.level2;

/**
 *  LeetCode674.给定一个未经排序的整数数组，
 *  找到最长且连续递增的子序列，并返回该序列的长度。
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {

    }

    public int findLengthOfLCIS(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int result = 1;

        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            if (A[i] > A[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else if (A[i] <= A[i - 1]) {
                dp[i] = 1;  // 也可以不做处理
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
