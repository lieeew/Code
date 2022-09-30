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

    public Programmer[] getTeam(int index) throws TeamException {

        Programmer[] team = new Programmer[MAX_MEMBER]; // 这里为什么要引入一个新的数组, 因为总长是几就会返回几个,会返回空的
        for (int a = 0; a < MAX_MEMBER; a++) {
            team[a] = this.team[a];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (MAX_MEMBER <= total) throw new TeamException("人已满");
        if (!(e instanceof Programmer)) throw new TeamException("非程序员");
        if(isExist(e.getId())) System.out.println();
        Programmer programmer = (Programmer) e;
        if ("BUSY".equals(programmer.getStatus().getNAME())) throw new TeamException("人员忙");
        int numOfArch = 0, numOfPro = 0, numOfDes = 0;
        for (int a = 0;a <total; a++) {
            if (team[a] instanceof Architect) {
                numOfArch++;
            } else if (team[a] instanceof Designer) {
                numOfDes++;
            } else {
                numOfPro++;
            }
        }
        if (e instanceof Architect && numOfArch > 2) throw new TeamException("errro");
        if (e instanceof Designer && numOfDes > 3) throw new TeamException("erro");
        if (e instanceof Programmer && numOfPro > 4) throw new TeamException("erro");

    }

    public boolean isExist (int index){
        for (int a = 0; a < total; a++) {
            if (team[a].getId() == index) {
                return true;
            }
        }
        return false;
    }
}
