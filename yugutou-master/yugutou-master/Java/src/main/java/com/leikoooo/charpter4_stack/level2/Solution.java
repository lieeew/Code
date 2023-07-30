package com.leikoooo.charpter4_stack.level2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // 偶数直接不行啊
        if (s.length() <= 1 || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> smap = new HashMap<>();
        smap.put('(', ')');
        smap.put('{', '}');
        smap.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (smap.containsKey(c)) {
                stack.push(smap.get(c));
            } else {
                if (!stack.isEmpty()) {
                    char left = s.charAt(i);
                    char right = stack.pop();
                    if (left != right) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test() {
        isValid("))");
    }
}