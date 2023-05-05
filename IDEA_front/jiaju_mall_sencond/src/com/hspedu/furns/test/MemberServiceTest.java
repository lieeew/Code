package com.hspedu.furns.test;

import com.hspedu.furns.DAO.MemberDAO;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;
import org.junit.Test;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */
public class MemberServiceTest {
    private MemberService memberService = new MemberServiceImpl();

    @Test
    public void test() {
        // Member leikooo = memberService.isExists("leikooo");
        // System.out.println("leikooo = " + leikooo);
        Member member = memberService.isExists("helloWorld");
        System.out.println(member);
    }

}
