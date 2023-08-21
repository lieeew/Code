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
}
