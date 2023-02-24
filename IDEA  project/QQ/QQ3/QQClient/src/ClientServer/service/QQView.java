package ClientServer.service;

import ClientServer.utils.Utility;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.text.resources.cldr.ti.FormatData_ti;

import java.awt.print.Printable;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/8 - 12 - 08
 * @Description: ClientServer
 */
public class QQView {
    public static void main(String[] args) {
        new QQView().enterView();
    }
    private boolean loop = true;

    public void enterView() {
        System.out.println("======欢迎进入系统=======");
        System.out.println("\t\t输入1进入系统: ");
        System.out.println("\t\t输入9退出系统: ");
        System.out.print("请输入你的选择: ");
        String choice = Utility.readString(20);
        MessageClientService messageClientService = new MessageClientService();
        switch (choice) {
            case "1":
                System.out.print("请输入账号: ");
                String count = Utility.readString(20);
                System.out.print("请输入密码: ");
                String passWorld = Utility.readString(30);
                while (messageClientService.checkUser(count, passWorld)) {
                    System.out.println("\n\n =====网络通信系统二级菜单( 用户" + count + " 登录系统) ====");
                    System.out.println("\t\t 1.显示在线人数");
                    System.out.println("\t\t 2.群发信息");
                    System.out.println("\t\t 3.私聊信息");
                    System.out.println("\t\t 4.发送文件");
                    System.out.println("\t\t 9.退出系统");
                    System.out.print("请输入你的选择:");
                    String isChoice = Utility.readString(12);
                    String content; // 内容
                    switch (isChoice) {
                        case "1":
                            System.out.println("====在线用户名单====");
                            messageClientService.getOnlineUsers(count);
                            break;
                        case "2":
                            System.out.println("请输入你想要发送的内容：");
                            content = Utility.readString(100);
                            messageClientService.sendMessageToAll(count, content);
                            break;
                        case "3":
                            System.out.println("请输入你要发送给谁：");
                            String getterId = Utility.readString(20);
                            System.out.println("请输入你想要发送的内容：");
                            content = Utility.readString(100);
                            messageClientService.sendMessageToOne(getterId, count, content);
                            System.out.println("\n" + count + " 给 " + getterId + " 发送的内容为 " + content);
                            break;
                        case "4":
                            System.out.print("请你输入发送文件的路径: ");
                            String src = Utility.readString(100);
                            System.out.print("请输入你要发送的对象: ");
                            String getterID = Utility.readString(100);
                            System.out.print("请输入你要存储到方的路径: ");
                            String des = Utility.readString(100);
                            messageClientService.sendFileToOne(des,src, getterID, count);
                            System.out.println("\n\n" + "你要发送给 " + getterID + " 磁盘下的路径为 " + des);
                            break;
                        case "9":
                            (new clientConnectServiceThread()).exitSystem(count);
                            loop = false;
                            break;
                    }
                }

                break;
            case "9" :
                System.out.println("退出系统!");
        }
    }
}
