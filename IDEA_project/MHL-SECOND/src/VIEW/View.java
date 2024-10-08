package VIEW;

import DOMAIN.DiningTable;
import SERVICE.DiningTableService;
import SERVICE.EmployeeService;
import UTILS.Utility;
import com.alibaba.druid.sql.visitor.functions.If;
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
                        while (isLoop) {
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
                                    showAllMenu();
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
        System.out.println("\n==============预定餐桌============");
        System.out.print("请选择要预定的餐桌编号(-1退出): ");
        int id = Utility.readInt(-1);
        if (id == -1) {
            System.out.println("==============取消预订餐桌============");
            return;
        }
        if (!diningTableService.isExist(id)) {
            System.out.println("==============预订餐桌不存在============");
            return;
        }
        System.out.print("确认是否预订Y/N");
        char c = Utility.readConfirmSelection();
        if (c == 'N') {
            System.out.println("==============取消预订餐桌============");
            return;
        }
        System.out.print("预定人的名字: ");
        String orderName = Utility.readString(50);
        System.out.print("预定人的电话: ");
        String orderTel = Utility.readString(50);
        if (diningTableService.orderDiningTable(orderName, orderTel, id)) {
            System.out.println("==============预订成功============");
        } else {
            System.out.println("==============预订失败============");
        }

    }

    /**
     * 显示所有菜品
     */
    public void showAllMenu() {
        

    }
}
