package qqclient.view;

import qqclient.service.UserClientService;
import qqclient.utils.Utility;

/**
 * @Author: qxy
 * @Date: 2023/1/29 13
 * @Description:
 */
public class view {
    private static boolean loop = true;
    private static UserClientService userClientService = new UserClientService();

    public static void test() {
        while (loop) {
            System.out.println("========欢迎登陆系统========");
            System.out.println("\t\t 1 表示登录系统: ");
            System.out.println("\t\t 9 表示退出系统: ");
            System.out.print("请输入你的选择 : ");
            int isChoice = Utility.readInt();
            System.out.print("请输入账号 : ");
            String account = Utility.readString(20);
            System.out.print("请输入密码 : ");
            String pwd = Utility.readString(20);
            switch (isChoice) {
                case 1:
                    if (userClientService.checkUer(account, pwd)) {
                        System.out.println("========欢迎登录" + account + "系统========");
                        while (true) {
                            System.out.println("\n=======网络通信二级菜单( 用户" + account + ")======");
                            System.out.println("\t\t 1.显示在线人数");
                            System.out.println("\t\t 2.群发信息");
                            System.out.println("\t\t 3.私聊信息");
                            System.out.println("\t\t 4.发送文件");
                            System.out.println("\t\t 9.退出系统");
                            System.out.print("请输入你的选择 : ");
                            int Choice = Utility.readInt();
                            String content;
                            String getter;
                            switch (Choice) {
                                case 1:
                                    userClientService.showUserList();
                                    break;
                                case 2:
                                    System.out.print("请你写出发送给全体的内容 : ");
                                    content = Utility.readString(20);
                                    userClientService.SendMessageToAll(account, content);
                                    break;
                                case 3:
                                    System.out.print("请输入你想发送的对象id : ");
                                    getter = Utility.readString(20);
                                    System.out.print("请你写出发送的内容 : ");
                                    content = Utility.readString(20);
                                    userClientService.SendMessageToOne(getter, account, content);
                                    break;
                                case 4:
                                    System.out.print("请输入你想发送的对象id : ");
                                    getter = Utility.readString(20);
                                    System.out.print("输入你文件的位置 : ");
                                    String src = Utility.readString(30);
                                    System.out.print("存入到对方的位置 : ");
                                    String desc = Utility.readString(30);
                                    userClientService.sendFile(src, desc, getter, account);
                                    System.out.println("\n\n" + account + " 给 " + getter + " 发送文件的位置在 " + desc);
                                    break;
                                case 9:
                                    userClientService.logOut();
                                    loop = false;
                                    System.out.println("退出系统");
                                    break;
                            }
                        }
                    }
                    break;
                case 9:
                    loop = false;
                    System.out.println("退出系统");
                    break;
                default:
                    System.out.println("输入有误, 请重新输入!");
            }
        }
    }

    public static void main(String[] args) {
        test();
    }
}
