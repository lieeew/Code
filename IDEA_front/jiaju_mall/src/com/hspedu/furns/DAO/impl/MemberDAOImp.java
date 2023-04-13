package com.hspedu.furns.DAO.impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.MemberDAO;
import com.hspedu.furns.entity.Member;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @Author: qxy
 * @Date: 2023/4/12
 * @Description:
 */
public class MemberDAOImp extends BasicDAO<Member> implements MemberDAO {

    /**
     * 通过名字获取数据
     */
    @Override
    public Member getMemberByName(String name) {
        return querySingle("SELECT * FROM member WHERE username = ?", Member.class, name);
    }

    /**
     * 把member对象保存到数据库中
     * @return 返回1是成功, 返回-1是失败
     */
    @Override
    public int saveMember(Member member) {
        if (member != null) {
            String username = member.getUsername();
            String password = member.getPassword();
            String email = member.getEmail();
            int update = update("INSERT INTO member VALUES(null, ?, md5(?), ?)", username, password, email);
            if (update > 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @Override
    public int deleteMember(@NotNull Member member) {
        int update = update("DELETE FROM member WHERE username = ?", member.getUsername());
        if (update > 0) {
            return 1;
        } else {
            return -1;
        }
    }


    @Override
    public Member queryMemberByNameAndPwd(String name, String pwd) {
        return querySingle("SELECT * FROM member WHERE username = ? AND `password` = MD5(?)", Member.class, name, pwd);
    }
}
