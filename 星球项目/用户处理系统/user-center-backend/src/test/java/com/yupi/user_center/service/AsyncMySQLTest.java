package com.yupi.user_center.service;

import com.yupi.user_center.UserCenterApplication;
import com.yupi.user_center.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author <a href="https://github.com/lieeew">leikooo</a>
 * @date 2024/12/9
 * @description
 */
@SpringBootTest(classes = UserCenterApplication.class)
public class AsyncMySQLTest {
//    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(20), new NamedThreadFactory("mysql-", true));

    @Resource
    private UserMapper userMapper;

    @Test
    public void test() {
        System.out.println("aaa");
//        User.builder().userAccount("leilll").userPassword("xxxx").userStatus(1).planetCode("123").build();
        userMapper.insertUser("aaaa");
//        threadPoolExecutor.execute(() -> {
//
//        });
    }

}
