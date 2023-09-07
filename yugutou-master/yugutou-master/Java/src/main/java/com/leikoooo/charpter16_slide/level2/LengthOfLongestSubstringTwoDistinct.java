package com.leikoooo.charpter16_slide.level2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串5，求包含最多2个不同字符的最长子串t的长度。
 *
 */
public class LengthOfLongestSubstringTwoDistinct {

    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        if (s.length() < 3) {
            return s.length();
        }
        int left = 0, right = 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int maxLen = 2;

        while (right < s.length()) {

            if (hashmap.size() < 3) {
                hashmap.put(s.charAt(right), right++);
            }

            // 如果大小达到了3个
            if (hashmap.size() == 3) {
                // 最左侧要删除的位置
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // 窗口left的新位置
                left = del_idx + 1;
            }

            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstringTwoDistinct2(String s) {

        if (s.length() < 3) {
            return s.length();
        }
        int left = 0, right = 0;
        int maxLen = 2;
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        while (right < s.length()) {
            if (map.size() < 3) {
                // 传入的 right++ 不会整体改变
                map.put(charArray[right], right++);
            }

            if (map.size() == 3) {
                // 删除最左边的文件
                int del_index = Collections.min(map.values());
                // 删除对应的
                map.remove(s.charAt(del_index));
                left = del_index + 1;
            }

            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstringTwoDistinct3(String s) {
        int left = 0, right = 0;
        // 最长的长度
        int maxLen = 2;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            if (map.size() < 3) {
                map.put(chars[right], right++);
            }

            if (map.size() == 3) {
                int delIndex = Collections.min(map.values());
                map.remove(chars[delIndex]);
                left = delIndex + 1;
            }

            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

}
