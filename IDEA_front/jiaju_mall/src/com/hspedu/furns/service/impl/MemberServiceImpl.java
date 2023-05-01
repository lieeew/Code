package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.MemberDAO;
import com.hspedu.furns.DAO.impl.MemberDAOImp;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;

/**
 * @Author: qxy
 * @Date: 2023/4/12
 * @Description:
 */
public class MemberServiceImpl implements MemberService {
    private MemberDAO memberDAO = new MemberDAOImp();

    /**
     * @return true 代表有用户
     */
    @Override
    public boolean register(Member member) {
        return memberDAO.saveMember(member) == 1;
    }

    @Override
    public boolean isExistsUsername(String username) {
        // false 表示存在用户名
        return memberDAO.getMemberByName(username) != null;
    }

    @Override
    public Member login(Member member) {
        return memberDAO.queryMemberByNameAndPwd(member.getUsername(), member.getPassword());

    }
}
