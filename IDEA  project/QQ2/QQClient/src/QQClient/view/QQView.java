package QQClient.view;

import QQClient.server.UserClientService;
import QQClient.utils.Utility;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/30 - 11 - 30
 * @Description: QQClient.view
 * 客户端页面
 */
public class QQView {
    public static void main(String[] args) {
        new QQView().enterMenu();
    }
    private boolean loop = true;
    private UserClientService userClientService = new UserClientService();

    public void enterMenu() {

        while (loop) {
            System.out.println("======欢迎登陆网络通信系统======");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择: ");
            int isChoice = Utility.readInt(1);
            // 根据用户的输入选择不同的逻辑
            switch (isChoice) {
                case 1:
                    System.out.println("*********登录系统*********");
                    System.out.println("请输入用户名: ");
                    String userId = Utility.readString(50);
                    System.out.println("请输入密 码:");
                    String passWord = Utility.readString(50);
                    // 这里代码比较麻烦
                    if (userClientService.checkUser(userId, passWord)) {
                        System.out.println("======欢迎( 用户" + userId + " )进入系统=====");
                        while (loop) {
                            System.out.println("\n=======网络通信二级菜单( 用户" + userId + ")======");
                            System.out.println("\t\t 1.显示在线人数");
                            System.out.println("\t\t 2.群发信息");
                            System.out.println("\t\t 3.私聊信息");
                            System.out.println("\t\t 4.发送文件");
                            System.out.println("\t\t 9.退出系统");
                            System.out.print("请输入你的选择:");
                            int isChoice2 = Utility.readInt();
                            switch (isChoice2) {
                                case 1 :
                                    System.out.println("显示在线人数");
                                    break;
                                case 2 :
                                    System.out.println("群发信息");
                                    break;
                                case 3 :
                                    System.out.println("私聊信息");
                                    break;
                                case 4 :
                                    System.out.println("发送文件");
                                    break;
                                case 9 :
                                    System.out.println("退出系统");
                                    loop = false;
                                    break;
                            }
                        }
                    } else { // 登录服务器失败
                        System.out.println("===== 登录服务器失败====");
                    }
                    break;
                case 2:
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }
        }
    }
}
