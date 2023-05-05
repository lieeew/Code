package com.hspedu.furns.test;

import com.hspedu.furns.DAO.Impl.MemberImpl;
import com.hspedu.furns.DAO.MemberDAO;
import com.hspedu.furns.entity.Member;
import org.junit.Test;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */
public class MemberDAOTest {
    private MemberDAO memberDAO = new MemberImpl();

    @Test
    public void testAddMember() {
        memberDAO.addMember(new Member(3, "hspedu", "hspedu", "hspedu@gmail.com"));
    }

    @Test
    public void getMemberByNameTest() {
        // Member leikooo = memberDAO.getMemberByName("leikooo");
        // System.out.println("leikooo = " + leikooo);
        Member member = new Member();
        member.setUsername("hspedu");
        member.setPassword("hspedu");
        Member member1 = memberDAO.VerifyUsernamePassword(member);
        System.out.println(member1);
        // System.out.println("i = " + i);
    }
}
