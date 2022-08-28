package com.atguigu.p2.ui;

import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.service.CustomerList;
import com.atguigu.p2.util.CMUtility;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/22 - 08 - 22
 * @Description: com.atguigu.p2.ui
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer cus = new Customer("lihua", '男', 18, "lihua@gamil.com", "2131232121");
        customerList.addCustomer(cus);
    }

    boolean isflage;

    public void enterMainMenu() {
        isflage = true;
        while (isflage) {

            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");
            char meu = CMUtility.readMenuSelection();

            switch (meu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("是否确认退出");
                    char isChoice = CMUtility.readConfirmSelection();
                    if (isChoice == 'Y') {
                        isflage = false;
                    }
            }
        }
    }

    /**
     * 添加
     */
    private void addNewCustomer() {
        System.out.println("---------添加客户------");
        System.out.print("姓名:");
        String name = CMUtility.readString(10);
        System.out.print("性别:");
        char sex = CMUtility.readChar();
        System.out.print("年龄:");
        int age = CMUtility.readInt();
        System.out.print("电话:");
        String phone = CMUtility.readString(14);
        System.out.print("邮箱:");
        String email = CMUtility.readString(13);
        // 将上述的属性封装到对象中
        Customer cus = new Customer(name,sex,age,email,phone);
        boolean isSuccess = customerList.addCustomer(cus);
        if (isSuccess) {
            System.out.println("--------添加成功------");
        }else {
            System.out.println("---------添加失败-----");
        }
    }

    /**
     * 修改
     */
    private void modifyCustomer() {
        System.out.println("修改客户");
        int num = CMUtility.readInt();
        Customer cus;
        for (; ; ) { // 循环相当于 whil(true)

            if (num == -1) {
                System.out.println("请输入客户信息(-1退出)");
                return;
            }
            cus = customerList.getCustomer(num - 1);
            if (cus == null) {
                System.out.println("无法找到用户");
                break;
            } else {
                break;
            }
        }
        System.out.print("姓名(" + cus.getName() + ")");
        String s = CMUtility.readString(10, cus.getName());
        System.out.print("性别(" + cus.getSex() + ")");
        char c = CMUtility.readChar(cus.getSex());
        System.out.print("年龄(" + cus.getAge() + ")");
        int i = CMUtility.readInt(cus.getAge());
        System.out.print("邮箱(" + cus.getEmail() + ")");
        String s1 = CMUtility.readString(13, cus.getEmail());
        System.out.print("电话(" + cus.getPhone() + ")");
        String s2 = CMUtility.readString(30, cus.getPhone());
        Customer newCust = new Customer(s, c, i, s1, s2);
        boolean isCustomer = customerList.replaceCustomer(num - 1, newCust);
        if (isCustomer) {
            System.out.println("0k");
        } else {
            System.out.println("失败");
        }
    }


    /**
     * 删除用户
     */
    private void deleteCustomer() {
        System.out.println("------删除用户-------");
        int i;
        Customer customer;
        for (; ; ) {
            System.out.println("删除与用户的编号(-1退出)");
            i = CMUtility.readInt();
            if (i == -1) {
                return;
            }
            customer = customerList.getCustomer(i ); // customerlist的地址给了customer
            if (customer == null) {
                System.out.println("未找到该用户");
            } else {
                break;
            }
        }
        // 一旦找到相应的索引位置的customer以后，让用户决定是否确认删除
        System.out.println("确认是否删除(Y/N)：");
        char isChooce = CMUtility.readConfirmSelection();
        if (isChooce == 'Y') {
            boolean b = customerList.deleteCustomer(i - 1);
            if (b) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        }else {
            return;
        }
    }

    /**
     * 客户列表
     */
    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        int total = customerList.getTotal();
        Customer[] customer = customerList.getAllCustomers();// 创建一个新的数组来存储customer数据

        if (total == 0) {
            System.out.println("没有用户!");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int a = 0; a < total; a++) {
                System.out.println((a + 1) + "\t" + customer[a].getName()
                        + "\t" + customer[a].getAge() + "\t" + customer[a].getPhone() +
                        "\t" + customer[a].getEmail());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");

    }

    public static void main(String[] args) {
        CustomerView teat = new CustomerView();
        teat.enterMainMenu();
    }

}