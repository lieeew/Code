package com.hspedu.furns.test;

import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import org.junit.Test;

/**
 * @Author: qxy
 * @Date: 2023/5/5
 * @Description:
 */
public class FurnServiceTest {
    private final FurnService furnService = new FurnServiceImpl();

    @Test
    public void test() {
        // 非常的ok
        furnService.page(3, 2);
    }

}
