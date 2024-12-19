//package com.yupi.user_center.service;
//
//import com.yupi.user_center.UserCenterApplication;
//import com.yupi.user_center.model.domain.User;
//import org.junit.Assert;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.util.DigestUtils;
//
//import javax.annotation.Resource;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @author leikooo
// * @create 2023-07-02 16:13
// * @Package com.yupi.user_center.service
// * @Description
// */
//@SpringBootTest
//class UserServiceTest {
//
//    @Resource
//    private UserService userService;
//
//    @Test
//    public void testAddUser() {
//        User user = new User();
//
//        user.setUsername("yupi");
//        user.setUserAccount("123");
//        user.setAvatarUrl("https://pic.code-nav.cn/user_avatar/1608460212774109186/4LsPUAdz-photo_2023-04-09_16-26-40.jpg");
//        user.setGender(0);
//        user.setUserPassword("xxx");
//        user.setPhone("123");
//        user.setEmail("456");
//        user.setUserStatus(0);
//
//        boolean result = userService.save(user);
//        System.out.println(user.getId());
//        // 断言测试
//        assertTrue(result);
//    }
//
//    @Test
//    public void testDigest() {
//        String s = DigestUtils.md5DigestAsHex(("123" + "salt").getBytes());
//        System.out.println("s = " + s);
//    }
//
//    @Test
//    void userRegister() {
//
//    }
//
//    @Test
//    public void testSql() {
//
//
//    }
//}