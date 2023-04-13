package com.hspedu.furns.test;

import com.hspedu.furns.DAO.impl.MemberDAOImp;
import com.hspedu.furns.entity.Member;
import org.junit.Test;

/**
 * @Author: qxy
 * @Date: 2023/4/12
 * @Description:
 */
public class MemverDAOTest {
    private MemberDAOImp memberDAOImp = new MemberDAOImp();

    @Test
    public void test() throws Exception {
        Member admin = memberDAOImp.getMemberByName("admin");
        if (admin == null) {
            System.out.println("用户不存在");
        } else {
            System.out.println("用户存在");
        }
    }

    @Test
    public void test2() {
        Member king = new Member(null, "king", "123456", "king@gmail.com");
        int i = memberDAOImp.saveMember(king);
        if (i == 1) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void test3() {
        Member king = new Member(null, "king", "123456", "king@gmail.com");
        int i = memberDAOImp.deleteMember(king);
        if (i == 1) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void test4() {
        // Member admin = memberDAOImp.queryMemberByNameAndPwd("king", "11111111");
        // if (admin == null) {
        //     System.out.println("不存在");
        // } else {
        //     System.out.println("存在");
        // }
    }
}
