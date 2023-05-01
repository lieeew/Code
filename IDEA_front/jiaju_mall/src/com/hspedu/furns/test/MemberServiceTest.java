package com.hspedu.furns.test;

import com.hspedu.furns.DAO.impl.MemberDAOImp;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;
import org.junit.Test;

/**
 * @Author: qxy
 * @Date: 2023/4/12
 * @Description:
 */
public class MemberServiceTest {

    private MemberService memberService = new MemberServiceImpl();

    @Test
    public void test1() {
        if (!memberService.isExistsUsername("admin")) {
            System.out.println("用户名不存在!");
        } else {
            System.out.println("用户名存在!");
        }
    }

    @Test
    public void test2() {
        Member marry = new Member(null, "marry", "mary@qq.com", "123456");
        memberService.register(marry);
    }
}
