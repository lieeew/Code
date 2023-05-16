package com.atguigu.service;

import com.atguigu.domain.Architect;
import com.atguigu.domain.Designer;
import com.atguigu.domain.Employee;
import com.atguigu.domain.Programmer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/6 - 10 - 06
 * @Description: com.atguigu.service
 */
public class TeamService {

    private int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] programmers = new Programmer[MAX_MEMBER];
    private int total;

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[programmers.length];
        for (int a = 0; a < team.length; a++) {
            team[a] = programmers[a];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {

        if (total > MAX_MEMBER) throw new TeamException("人员已满");
        if (!(e instanceof Programmer)) throw new TeamException("该成员不是开发人员，无法添加");
        if ( ! isExit(e)) throw new TeamException("该员工已添加");
        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus())) throw new TeamException("该员工忙无法添加");
        if ("VACATION".equals(p.getStatus())) throw new TeamException("该员工正在度假");

        int NumOfPro = 0, NumOfDes = 0, NumOfArch = 0;

        for (int a = 0; a < programmers.length; a++) {
            if (programmers[a] instanceof Designer) NumOfDes++;
            if (programmers[a] instanceof Architect) NumOfArch++;
            if (programmers[a] instanceof Programmer) NumOfPro++;
        }
        if (e instanceof Architect) {
            if (NumOfArch >= 1) throw new TeamException("团队中至多只能有一名架构师");
        } else if (e instanceof Designer) {
            if (NumOfDes >= 2) throw new TeamException("团队中至多只能有两名设计师");
        } else {
            if (NumOfPro >= 3) throw new TeamException("团队中至多只能有三名程序员");
        }

        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        programmers[total++] = p;

    }

    public boolean isExit(Employee e) {
        for (int a = 0; a < programmers.length; a++) {
            if (programmers[a].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }
}