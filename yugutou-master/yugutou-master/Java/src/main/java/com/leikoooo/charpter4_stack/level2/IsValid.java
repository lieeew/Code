package com.leikoooo.charpter4_stack.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {

    static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        // 符号对应的
        Map<String, String> symbolMap = new HashMap<>();
        symbolMap.put(")", "(");
        symbolMap.put("]", "[");
        symbolMap.put("}", "{");

        Stack<String> stack = new Stack<>();
        // 先将元素都写入到栈里面
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(String.valueOf(c));
        }

        // 一边出栈一边判断
        while (!stack.isEmpty()) {
            if (!symbolMap.get(stack.pop()).equals(stack.pop())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
