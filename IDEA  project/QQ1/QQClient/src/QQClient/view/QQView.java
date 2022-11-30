package QQClient.view;

import QQClient.Service.MessageClientService;
import QQClient.Service.userClientService;
import QQClient.utils.Utility;
import com.qqcommon.User;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/26 - 11 - 26
 * @Description: QQClientView
 */
public class QQView {
    public static void main(String[] args) {
        QQView qqView = new QQView();
        qqView.show();
    }

    private boolean loop = true;

    //显示主菜单
    public void show() {

        while (loop) {
            System.out.println("======欢迎登录网络通信系统======");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择: ");
            Scanner sc = new Scanner(System.in);
            int i = Utility.readInt();
            // 二级菜单
            switch (i) {
                case 1:
                    System.out.println("*************进入系统*************");
                    System.out.print("请输入账 号: ");
                    String count = sc.next();
                    System.out.print("请输入密 码: ");
                    String password = sc.next();
                    userClientService userClientService = new userClientService();
                    MessageClientService messageClientService = new MessageClientService();
                    // 下面就需要打包发个服务器检验数据
                    // 这里面有很多代码, 我们先编写一个类 userClientService[用户登录验证]
                    if (userClientService.cheekUser(count, password)) { // 还没有些完, 先写大体框架
                        System.out.println("======欢迎( 用户" + count + " )进入系统=====");

                        while (loop) {
                            System.out.println("\n\n =====网络通信系统二级菜单( 用户" + count + " 登录系统) ====");
                            System.out.println("\t\t 1.显示在线人数");
                            System.out.println("\t\t 2.群发信息");
                            System.out.println("\t\t 3.私聊信息");
                            System.out.println("\t\t 4.发送文件");
                            System.out.println("\t\t 9.退出系统");
                            System.out.print("请输入你的选择:");
                            int isChoice = Utility.readInt();
                            switch (isChoice) {
                                case 1 :
                                    userClientService.getOnlineFriendList();
                                    break;
                                case 2 :
                                    System.out.println("群发信息");
                                    break;
                                case 3 :
                                    System.out.println("请输入想聊天的用户(在线):");
                                    String getterId = Utility.readString(20);
                                    System.out.println("请输入你想聊天的内容:");
                                    String counted = Utility.readString(50);
                                    messageClientService.sendMessageToOne(counted, getterId, count);
                                    break;
                                case 4 :
                                    System.out.println("发送文件");
                                break;
                                case 9 :
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else { // 登录服务器失败
                        System.out.println("===== 登录服务器失败====");
                    }
                    break;

                case 9:
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }
        }
    }
}
