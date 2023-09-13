package com.leikoooo.charpter16_slide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] sArrays = new int[26];
        int[] pArrays = new int[26];

        for (int i = 0; i < pLen; i++) {
            sArrays[s.charAt(s.charAt(i)) - 'a']++;
            pArrays[p.charAt(p.charAt(i)) - 'a']++;
            if (Arrays.equals(sArrays, pArrays)) {
                result.add(i);
            }
        }

        for (int right = pLen; right < sLen; right++) {
            sArrays[p.charAt(right)  - 'a' ]++;
            sArrays[p.charAt(right) - 'a' - pLen]--;
            if (Arrays.equals(sArrays, pArrays)) {
                result.add(right - pLen);
            }
        }
        return result;
    }
}