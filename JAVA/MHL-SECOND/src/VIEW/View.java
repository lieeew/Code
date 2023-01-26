package VIEW;

import DOMAIN.DiningTable;
import DOMAIN.Menu;
import SERVICE.BillService;
import SERVICE.DiningTableService;
import SERVICE.EmployeeService;
import SERVICE.MenuService;
import UTILS.Utility;
import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
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
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();
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
                                    orderFood();
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
     * 显示菜品名称
     */
    public void showAllMenu() {
        List<Menu> menus = menuService.menuList();
        System.out.println("\n菜品编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

    /**
     * 点餐服务
     */
        public void orderFood() {
            System.out.println("==============点餐服务============");
            System.out.print("点餐桌号(-1退出) : ");
            int diningTableId = Utility.readInt();
            if (diningTableId == -1) {
                System.out.println("=========退出=========");
                return;
            }
            if (!diningTableService.isExitFree(diningTableId)) {
                System.out.println("=========该餐桌不存在=========");
                return;
            }
            System.out.print("菜品编号(-1退出) : ");
            int menuId = Utility.readInt();
            if (menuId == -1) {
                System.out.println("=========退出=========");
                return;
            }
            if (!menuService.isExist(menuId)) {
                System.out.println("=========该餐组不存在=========");
                return;
            }
            System.out.print("菜品数量(-1退出) : ");
            int nums = Utility.readInt();
            if (nums == -1) {
                System.out.println("=========退出=========");
                return;
            }

            if (billService.orderMenu(diningTableId, menuId, nums, "就餐中")) {
                System.out.println("=========成功=========");
            } else {
                System.out.println("=========失败=========");
            }
        }
}
