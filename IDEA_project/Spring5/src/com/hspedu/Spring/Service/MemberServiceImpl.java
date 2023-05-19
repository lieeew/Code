package com.hspedu.Spring.Service;

import com.hspedu.Spring.DAO.MemberDAOImpl;

/**
 * ClassName: MemberService
 * Package: com.hspedu.Spring.Service
 *
 * @Author: leikooo
 * @Creat: 2023/5/18 - 10:25
 * @Description:
 */
public class MemberServiceImpl {
    private MemberDAOImpl memberDAO;

    public MemberServiceImpl() {
        System.out.println("MemberServiceImpl 构造器~");
    }

    public MemberDAOImpl getMemberDAO() {
        return memberDAO;
    }

    public void setMemberDAO(MemberDAOImpl memberDAO) {
        this.memberDAO = memberDAO;
    }

    public void add() {
        System.out.println("MemberServiceImpl add()...");
        memberDAO.add();
    }
}