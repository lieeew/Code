package com.sgg.serve;

import com.sgg.domain.Architect;
import com.sgg.domain.Designer;
import com.sgg.domain.Employee;
import com.sgg.domain.Programmer;
import com.sgg.view.Status;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/2 - 11 - 02
 * @Description: com.sgg.serve
 */
public class TeamService {
    private static int counter = 1; // 用于生成唯一的memberId
    private final int MAX_MEMBER = 5; // 团队最大人数
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0; // 记录实际人数

    /**
     * 返回当前团队的所有对象
     * @return 全体成员对象
     */
    public Programmer[] getTeam() {
        Programmer[] realTeam = new Programmer[total];
        for (int i = 0; i < realTeam.length; i++) {
            realTeam[i] = team[i];
        }
        return realTeam;
    }

    /**
     * 添加成员
     * @param e
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) throw new TeamException("成员已满");

        if (!(e instanceof Programmer)) throw new TeamException("该成员不是开发人员，无法添加");

        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                throw new TeamException("该员工已在本开发团队中");
            }
        }

        if (((Programmer) e).getStatus().equals(Status.BUSY)) {
            throw new TeamException("该员工已是某团队成员 ");
        }

        if (((Programmer) e).getStatus().equals(Status.VOCATION)) {
            throw new TeamException("该员正在休假，无法添加");
        }


        int TotalPro = 0, TotalArch = 0, TotalDesi = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) TotalArch++;
            else if (team[i] instanceof Designer) TotalDesi++;
            else if (team[i] instanceof Programmer) TotalPro++;
        }

        if (e instanceof Architect) {
            if (TotalArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (e instanceof Designer) {
            if (TotalDesi >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (e instanceof Programmer) {
            if (TotalPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        /**
         * 这个逻辑不对
         * 首先如果team中有两个设计师, 第一个不满足, 运行到第二行就会输出  团队中至多只能有两名设计师;
         */
//        if (e instanceof Architect && TotalArch > 1) throw new TeamException("团队中至多只能有一名架构师");
//        else if (e instanceof Designer && TotalDesi > 2) throw new TeamException("团队中至多只能有两名设计师");
//        else if (e instanceof Programmer && TotalPro > 3) throw new TeamException("团队中至多只能有三名程序员");
        // 添加到数组
        team[total++] = (Programmer) e;
        ((Programmer) e).setMemberId(counter++);
        ((Programmer) e).setStatus(Status.BUSY);

    }

    public void removeMember(int memberId) throws TeamException {
        int i;
        for (i = 0; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i == total) {
            throw new TeamException("未找到该用户");
        }
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        team[--total] = null;
    }

}
