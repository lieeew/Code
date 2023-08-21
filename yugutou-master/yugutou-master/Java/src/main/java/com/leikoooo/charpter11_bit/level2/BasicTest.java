package com.leikoooo.charpter11_bit.level2;

import org.junit.jupiter.api.Test;

/**
 * @author leikooo
 * @create 2023-08-18 9:59
 * @Package com.leikoooo.charpter11_bit.level2
 * @Description 测试最简单的增删改查
 */
public class BasicTest {

    /**
     * 如果是 1 返回 true
     * 如果是 0 返回 false
     *
     * @param num
     * @param i
     * @return
     */
    public boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    /**
     * 设置数据，将第 i 位设置成 1
     *
     * @param num
     * @param i
     * @return
     */
    public int setBit(int num, int i) {
        return num | (1 << i);
    }

    /**
     * 清空数据，把第 i 位设置成 0
     *
     * @param num
     * @param i
     * @return
     */
    public int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num | mask;
    }

    /**
     * 更新对应 i 位置的值变成 v
     *
     * @param num 对应的值
     * @param i   跟新帝第几位
     * @param v   要跟新的值
     * @return
     */
    public int updateBit(int num, int i, int v) {
        int mask = ~(1 << i);
        return (num & mask) | (v << i);
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int sign = (a & b) << 1;
            a = a ^ b;
            b = sign;
        }
        return a;
    }

    @Test
    public void test() {
        getSum(1, 3);
    }
}
