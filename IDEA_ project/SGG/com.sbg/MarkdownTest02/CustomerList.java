package MarkdownTest02;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/11 - 09 - 11
 * @Description: MarkdownTest02
 */
public class CustomerList {

    private Customer[] customers; // 用来保存客户对象的数组
    private int total = 0; // 记录客户的总数

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    // 添加客户
    public boolean addCustomer(Customer customer) {
        if (total < customers.length && total >= 0) {
            customers[total ] = customer;
            total++;
            return true;
        }else {
            return false;
        }
    }


    // 修改用户
    public boolean replaceCustomer(int index, Customer cust) {
        if (index <= total && index >= 0) {
            customers[index] = cust;
            return true;
        }
        return false;
    }

    // 删除用户
    public boolean deleteCustomer(int index) {
        if (index < total && index >= 0) {
            for (int a = index; a < total ; a ++) {
                customers[a] = customers[a + 1];
                customers[--total] = null;
            }
            return true;
        }
        return false;
    }

    //

    public Customer[] getAllCustomers() {
        Customer[] cus = new Customer[total];
        for (int a = 0; a < total; a ++) {
            cus[a]  = customers[a];
        }
        return cus;
    }


    public Customer getCustomer(int index) {
        if (index > total || index < 0) {
            System.out.println("请输入正确的形式");
            return null;
        }
        return  customers[index];
    }

    public int getTotal() {
        return total;
    }
}
