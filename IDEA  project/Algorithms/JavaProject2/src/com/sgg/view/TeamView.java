package com.sgg.view;

import com.sgg.domain.Employee;
import com.sgg.domain.Programmer;
import com.sgg.serve.NameListService;
import com.sgg.serve.TSUtility;
import com.sgg.serve.TeamException;
import com.sgg.serve.TeamService;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/2 - 11 - 02
 * @Description: com.sgg.view
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();


    public void enterMainMenu()  {

        boolean isFlage = true;
        char IsChoice = '0';
        while (isFlage){
            if (!(IsChoice == '1')) {
                System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
                listAllEmployees();
                System.out.println("---------------------------------------------------------------------------------------");
            }
            System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)： ");
            IsChoice = TSUtility.readMenuSelection();

            switch (IsChoice) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("你确定退出吗?");
                    char choice = TSUtility.readConfirmSelection();
                    if (choice == 'Y') {
                        System.out.println("确认是否退出(Y/N)");
                        isFlage = false;
                    }
                    break;
            }
        }
    }

    public void listAllEmployees() {
        Employee[] allEmployee = listSvc.getAllEmployee();
        for (int i = 0; i < allEmployee.length; i++) {
            System.out.println(allEmployee[i]);
        }

    }

    public void getTeam() {
        Programmer[] team = teamSvc.getTeam();
        if (team.length == 0 || team == null) {
            System.out.println("未添加用户");
        } else {
            System.out.println("--------------------团队成员列表---------------------");
            System.out.println("TDI/ID  姓名    年龄      工资       职位      奖金        股票");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailTeamView());
            }
        }

    }

    public void addMember()  {
        System.out.println("---------------------添加成员---------------------");
        System.out.println("请输入需要添加的序号:");
        int isChoice = TSUtility.readInt();

        try {
            Employee employee = listSvc.getEmployee(isChoice);
            teamSvc.addMember(employee);
            System.out.println("添加成功!");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
    }

    public void deleteMember()  {
        System.out.println("---------------------删除成员---------------------");
        int isChoice = TSUtility.readInt();
        System.out.println("确认是否删除(Y/N)：");
        char choose = TSUtility.readConfirmSelection();
        if (choose == 'Y') {
            try {
                teamSvc.removeMember(isChoice);
                System.out.println("删除成功!");
            } catch (TeamException e) {
                System.out.println("添加失败，原因：" + e.getMessage());
            }
            TSUtility.readReturn();
        } else {
            System.out.println("取消删除");
            return;
        }

    }


    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();

    }
}
