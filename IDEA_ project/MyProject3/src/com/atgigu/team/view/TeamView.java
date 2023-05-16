package com.atgigu.team.view;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/2 - 10 - 02
 * @Description: com.atgigu.team.view
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() throws TeamException {
        boolean LoopFlage = true;
        char menu = 0;
        while (LoopFlage) {
            if (menu != '1') listAllEmployees();
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addEmployee();
                    break;
                case '3':
                    deleteEmployye();
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N)：");
                    char isChoice = TSUtility.readConfirmSelection();
                    if (isChoice == 'Y') {
                        LoopFlage = false;
                    }
                    break;
            }
        }
    }


    /**
     * 显示所有的用户信息
     */
    public void listAllEmployees() {
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] allEquipment = listSvc.getAllEquipment();

        if (allEquipment == null || allEquipment.length == 0) {
            System.out.println("没有数据");
        } else {
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t\t职位\t\t状态\t\t奖金\t\t\t股票\t\t领用设备");
            for (int i = 0; i < allEquipment.length; i++) {
                System.out.println(allEquipment[i].toString());
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void getTeam() throws TeamException {
        System.out.println("\n--------------------团队成员列表---------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("没有用户");
        } else {
            System.out.println("请输入你要查找的序号:");
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for(int a = 0; a < team.length; a++) {
                System.out.println(team[a].getDetailTeamView());
            }
        }
        System.out.println("-----------------------------------------------------");

    }
    public  void addEmployee() {
        System.out.println("---------------------添加成员---------------------");
        System.out.println("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功");
            TSUtility.readReturn();
        } catch (TeamException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmployye () {
        int index = TSUtility.readInt();
        try {
            teamSvc.removeMember(index);
        } catch (TeamException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        try {
            teamView.enterMainMenu();
        } catch (TeamException e) {
            throw new RuntimeException(e);
        }
    }
}