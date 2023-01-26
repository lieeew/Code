package VIEW;

import DOMAIN.DiningTable;
import SERVICE.DiningTableService;
import SERVICE.EmployeeService;
import UTILS.Utility;
import org.junit.Test;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/1/25 11
 * @Description:
 */
public class View {
    private boolean isLoop = true;
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    @Test
    public void mainView() {
        while (isLoop) {
            System.out.println("=========满汉楼=========");
            System.out.println("   1    登录满汉楼");
            System.out.println("   2    退出满汉楼");
            System.out.print("请输入你的选择: ");
            char isChoice = Utility.readMenuSelection();
            switch (isChoice) {
                case '1' :
                    System.out.print("请输入员工号 : ");
                    String account = Utility.readString(20);
                    System.out.print("请输入密 码 : ");
                    String psw = Utility.readString(20);
                    if (employeeService.logIn(account, psw)) {
                        System.out.println("\n=========登录成功=========");
                        if (isLoop) {
                            System.out.println("\n===============满汉楼(二级菜单)================");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出满汉楼");
                            System.out.print("请输入你的选择: ");
                            String choice = Utility.readString(1);
                            switch (choice) {
                                case "1":
                                    listDiningTable();
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    System.out.println("显示所有菜品");
                                    break;
                                case "4":
                                    System.out.println("点餐服务");
                                    break;
                                case "5":
                                    System.out.println("查看账单");
                                    break;
                                case "6":
                                    System.out.println("结账");
                                    break;
                                case "9":
                                    isLoop = false;
                                    System.out.println("退出满汉楼");
                                    break;
                            }
                        }

                    } else {
                        System.out.println("\n=========账号或密码错误=========");
                    }
                    break;
                case '2':
                    isLoop = false;
                    System.out.println("=========退出系统=========");
                    break;
            }
        }
    }

    /**
     * 显示餐桌状态
     */
    public void listDiningTable () {
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable.toString());
        }
        System.out.println("==============显示完毕============");
    }

    /**
     * 预订餐桌
     */
    public void orderDiningTable() {

    }
}
