package com.leikoooo.charpter11_bit;

import org.junit.jupiter.api.Test;

/**
 * @author leikooo
 * @create 2023-08-20 19:59
 * @Package com.leikoooo.charpter11_bit
 * @Description
 */
public class multiplyTest {

    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int ans = 0;
        for (int i = 0; min != 0; i++) {
            //位为1时才更新ans，否则max一直更新
            if ((min & 1) == 1) {
                ans += max;
            }
            min >>= 1;
            max += max;
        }
        return ans;
    }

    @Test
    public void test() {

        multiply(12, 2);

    }

    public static int myAtoi(String str) {
        int len = str.length();
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说只能存储 32 位大小的有符号整数，下面两个if分别处理整数和负数的情况。
            // 提前判断乘以10以后是否越界,但res*10可能会越界，所以这里使用Integer.MAX_VALUE/10，这样一定不会越界。
            // 这是解决溢出问题的经典处理方式
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 合法的情况下，才考虑转换，每一步都把符号位乘进去
            // 想想这里为什么要带着sign乘
            res = res * 10 + sign * (currChar - '0');
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        myAtoi("    -12345K6");

    }
}
