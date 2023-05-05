package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.Member;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */
public interface MemberDAO {

    // 查询DB中信息
    Member getMemberByName(String name);

    // 添加到DB
    int addMember(Member member);

    Member VerifyUsernamePassword(Member member);
}
