package qqclient.view;

import com.sun.media.sound.FFT;
import com.sun.org.apache.bcel.internal.generic.IFGE;
import org.junit.Test;
import qqclient.utils.Utility;

import javax.rmi.CORBA.Util;
import java.time.temporal.ValueRange;

/**
 * @Author: qxy
 * @Date: 2023/1/29 13
 * @Description:
 */
public class view {
    private boolean loop = true;

    @Test
    public void test() {
        while (loop) {
            System.out.println("========欢迎登陆系统========");
            System.out.println("\t\t 1 表示登录系统: ");
            System.out.println("\t\t 9 表示退出系统: ");
            System.out.print("请输入你的选择 : ");
            System.out.print("请输入账号 :");
            String account = Utility.readString(20);
            System.out.print("请输入密码 :");
            String pwd = Utility.readString(20);
            int isChoice = Utility.readInt();
            switch (isChoice) {
                case 1:
                    if (true) {
                        System.out.println("========欢迎登录" + "jack" + "系统========");
                        while (true) {
                            System.out.println("\n=======网络通信二级菜单( 用户" + "jack" + ")======");
                            System.out.println("\t\t 1.显示在线人数");
                            System.out.println("\t\t 2.群发信息");
                            System.out.println("\t\t 3.私聊信息");
                            System.out.println("\t\t 4.发送文件");
                            System.out.println("\t\t 9.退出系统");
                            System.out.print("请输入你的选择:");
                            int Choice = Utility.readInt();
                            switch (Choice) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 9:
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
            }
        }
    }
}
