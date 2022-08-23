package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/22 - 08 - 22
 * @Description: com.atguigu.p2.service
 */
public class CustomerList {
    private Customer[] customers; //用来保存客户对象的数组
    private int total = 0;       //记录已保存客户对象的数量

    /**
     * 添加客户
     * @param totalCustomer
     */
    public CustomerList(int totalCustomer) {

        Customer[] cus = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
        if (total < customers.length) {
            customers[total] = customer;
            total ++;
            return true;
        } else {
            return false;
        }
    }

    public boolean replaceCustomer(int index, Customer cust) {
        if (index < total && index > 0) {
            customers[index] = cust;
            return true;
        }else {
            return false;
        }
    }
    public Customer[] getAllCustomers() {
        Customer[] cus = new Customer[total];
        for (int a = 0; a < total; a++) {
               cus[a] = customers[a];
        }
        return cus;
    }
    public Customer getCustomer(int index) {
        if (index >= total || index < 0) {
            System.out.println("从0开始");
            return null;
        }else {
            return customers[index];
        }
    }
    public int getTotal () {
        return total;
    }

}