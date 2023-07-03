package com.yupi.user_center.service;

import com.yupi.user_center.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liang
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-07-02 16:09:52
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册方法
     *
     * @param userAccount   用户账号
     * @param userPassword  用户密码
     * @param checkPassword 第二次密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     *
     * @param userAccount  用户账号
     * @param userPassword 用户密码
     * @return 返回脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

}
