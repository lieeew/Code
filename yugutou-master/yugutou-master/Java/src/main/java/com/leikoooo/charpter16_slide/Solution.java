package com.leikoooo.charpter16_slide;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        int len = s.length();
        int res = 0;
        while (right < len) {
            if (map.containsKey(chars[right])) {
                left = Math.max(left, map.get(chars[right]) + 1);
            }
            map.put(chars[right], right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    @Test
    public void test() {
        lengthOfLongestSubstring("abba");
    }
}