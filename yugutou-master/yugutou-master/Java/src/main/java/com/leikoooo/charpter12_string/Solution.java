
package com.leikoooo.charpter12_string;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    @Test
    public void test() {

    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        // 如果是相等的话或者是都是空字符串那么返回 true
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sIsMap = new HashMap<>();
        Map<Character, Integer> tIsMap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            sIsMap.put(ch, sIsMap.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : t.toCharArray()) {
            tIsMap.put(ch, tIsMap.getOrDefault(ch, 0) + 1);
        }
        for (Character key : tIsMap.keySet()) {
            if (!sIsMap.containsKey(key)) {
                return false;
            }
            if (tIsMap.get(key) != sIsMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1Chars = s1.toCharArray();
        Map<Character, Integer> s1Map = getMap(s1);
        Map<Character, Integer> s2Map = getMap(s2);
        for (char s1Char : s1Chars) {
            if (!s2Map.containsKey(s1Char) || s2Map.get(s1Char) != s1Map.get(s1Char)) {
                return false;
            }
        }
        return true;
    }

    // 统计指定字符串str中各字符的出现次数，并以Map的形式返回
    private Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        return map;
    }
}