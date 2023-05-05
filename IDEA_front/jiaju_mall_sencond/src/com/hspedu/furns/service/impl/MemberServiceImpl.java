package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.Impl.MemberImpl;
import com.hspedu.furns.DAO.MemberDAO;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO = new MemberImpl();

    @Override
    public int addMember(Member member) {
        return memberDAO.addMember(member);
    }

    @Override
    public Member isExists(String username) {
        return memberDAO.getMemberByName(username);
    }

    @Override
    public Member login(Member member) {
        return memberDAO.VerifyUsernamePassword(member);
    }
}
