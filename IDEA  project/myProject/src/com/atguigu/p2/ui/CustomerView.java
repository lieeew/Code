package com.atguigu.p2.ui;

import com.atguigu.p2.service.CustomerList;

import java.util.Scanner;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/22 - 08 - 22
 * @Description: com.atguigu.p2.ui
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);

    public void enterMainMenu() {
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();

        System.out.println("\n-----------------客户信息管理软件-----------------\n");
        System.out.println("                   1 添 加 客 户");
        System.out.println("                   2 修 改 客 户");
        System.out.println("                   3 删 除 客 户");
        System.out.println("                   4 客 户 列 表");
        System.out.println("                   5 退       出\n");
        System.out.print("                   请选择(1-5)：" + choose);
        switch (choose) {
            case 1:
                addNewCustomer();
            case 2:
                modifyCustomer();
            case 3:
                deleteCustomer();
            case 4:
                listAllCustomers();
            case 5:


        }
    }

    /**
     * 添加
     */
    private void addNewCustomer() {

    }

    /**
     * 修改
     */
    private void modifyCustomer() {

    }

    /**
     * 删除用户
     */
    private void deleteCustomer() {

    }

    /**
     * 客户列表
     * @param
     */
    private void listAllCustomers() {

    }





    public static void main(String[] args) {

    }
}