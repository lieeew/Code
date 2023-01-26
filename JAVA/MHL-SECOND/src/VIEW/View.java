package VIEW;

import SERVICE.EmployeeService;
import UTILS.Utility;
import org.junit.Test;

/**
 * @Author: qxy
 * @Date: 2023/1/25 11
 * @Description:
 */
public class View {
    private EmployeeService employeeService = new EmployeeService();
    @Test
    public void mainView() {
        boolean isLoop = true;
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

}
