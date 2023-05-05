package com.hspedu.furns.service;

import com.hspedu.furns.entity.Member;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */
public interface MemberService {

    /**
     * 添加到数据到数据库
     * @param member 需要添加的member对象
     */
    int addMember(Member member);

    Member isExists(String username);

    Member login (Member member);

}
