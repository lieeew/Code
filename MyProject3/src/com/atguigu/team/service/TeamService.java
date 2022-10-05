package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/29 - 09 - 29
 * @Description: com.atguigu.team.service
 */
public class TeamService {

    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;

    public Programmer[] getTeam() throws TeamException {

        Programmer[] team = new Programmer[total]; // 这里为什么要引入一个新的数组, 因为总长是几就会返回几个,会返回空的
        for (int a = 0; a < total; a++) {
            team[a] = this.team[a];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (MAX_MEMBER <= total) throw new TeamException("成员已满，无法添加");
        if (!(e instanceof Programmer)) throw new TeamException("该成员不是开发人员，无法添加");
        Programmer programmer = (Programmer) e;
        if (isExist(programmer)) throw new TeamException("该员工已在本团队中");
        if ("BUSY".equals(programmer.getStatus().getNAME())) throw new TeamException("人员忙");
        else if ("VOCATION".equals(programmer.getStatus().getNAME())) throw new TeamException("该员正在休假，无法添加");

        int numOfArch = 0, numOfPro = 0, numOfDes = 0;

        for (int a = 0; a < total; a++) {
            if (team[a] instanceof Architect) numOfArch++;
            else if (team[a] instanceof Designer) numOfDes++;
            else if (team[a] instanceof Programmer) numOfPro++;
        }
        // 正确的写法
        if (e instanceof Architect) {// 多个if 那么如果满足那么就都进行 然而如果说if else 那么如果就满足第一个那么就不会运行其他的
            if (numOfArch >= 1) throw new TeamException("团队中至多只能有一名架构师");
        } else if (e instanceof Designer) {
            if (numOfDes >= 2) throw new TeamException("团队中至多只能有两名设计师");
        } else {
            if (numOfPro >= 3) throw new TeamException("团队中至多只能有三名程序员");
        }

        programmer.setStatus(Status.BUSY);
        programmer.setMermberId(counter++);
        team[total++] = programmer;


        // 错误的写法, 如果说是这个写法, 那么如果第一个不通过,就会跳到下一步那么就不可以了. 而上面的那个方法就算人数有问题也不会跳到写一个大循环
//        if (e instanceof Architect && numOfArch > 2) throw new TeamException("errro");
//        else if (e instanceof Designer && numOfDes > 3) throw new TeamException("erro");
//        else if (e instanceof Programmer && numOfPro > 4) throw new TeamException("erro");

    }

    public boolean isExist(Programmer p) {
        for (int a = 0; a < total; a++) {
            if (team[a].getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int a;
        for (a = 0; a < total; a++) {
            if (team[a].getMermberId() == memberId) {
<<<<<<< HEAD
                team[a].setStatus(Status.FREE);
=======
                team[a].setStatus(Status.BUSY);
>>>>>>> fa395807bd83c9e68833043fae392cdfabd4a665
                break;
            }
        }
        // a == total 证明未进入过上述if语句而结束的
        if (a == total) {
            throw new TeamException("未找到该用户");
        }

        // 写法一
        for (int j = memberId; j < total - 1; j++) {
            team[j] = team[j + 1];
        }
        // 写法二
//        for (int k = memberId + 1; k < total; k++) {
//            team[k - 1] = team[k];
//        }
        // 写法一
        team[--total] = null;
        // 写法二
//        team[total - 1] = null;
//        total--;

    }
}