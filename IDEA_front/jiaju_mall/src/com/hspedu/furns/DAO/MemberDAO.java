package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.Member;

/**
 * @Author: qxy
 * @Date: 2023/4/12
 * @Description:
 */
public interface MemberDAO {

    /**
     * 通过名字获取 对应地member对象
     */
    Member getMemberByName(String name);

    /**
     * 把member对象保存到数据库中
     * @return 返回1是成功, 返回-1是失败
     */
    int saveMember(Member member);

    /**
     * 删除数据库中的用户
     * @return 返回1是成功, 返回-1是失败
     */
    int deleteMember(Member member);

}
