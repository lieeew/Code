package com.hspedu.furns.service;

import com.hspedu.furns.entity.Member;

/**
 * @Author: qxy
 * @Date: 2023/4/12
 * @Description:
 */
public interface MemberService {

    /**
     * 注册用户
     */
    boolean register(Member member);

    /**
     * 判断用户是否存在
     */
    boolean isExistsUsername(String username);
}
