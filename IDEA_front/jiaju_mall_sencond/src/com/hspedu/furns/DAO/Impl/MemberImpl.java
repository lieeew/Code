package com.hspedu.furns.DAO.Impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.MemberDAO;
import com.hspedu.furns.entity.Member;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */
public class MemberImpl extends BasicDAO<Member> implements MemberDAO {


    @Override
    public Member getMemberByName(String name) {
        String sql = "select `id`, `username`, `password`, `email` from member where `username` = ?;";
        return querySingle(sql, Member.class, name);
    }

    @Override
    public int addMember(Member member) {
        String sql = "INSERT INTO member(`id`, `username`,`password`,`email`) " +
                "VALUES(? , ?, md5(?), ?)";
        return update(sql, member.getId(), member.getUsername(), member.getPassword(), member.getEmail());
    }

    @Override
    public Member VerifyUsernamePassword(Member member) {
        String sql = "select `id`, `username`, `password`, `email` from member where `username` = ? and `password` = md5(?)";
        return querySingle(sql, Member.class, member.getUsername(), member.getPassword());
    }
}
