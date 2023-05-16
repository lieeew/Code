package project;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/26 - 08 - 26
 * @Description: project
 */
public class CustomerList {
    private int total; // 用来计数
    private Customer[] customers; //用来保存客户对象的数组

    public CustomerList(int totalCustomer) {

        customers = new Customer[totalCustomer];
    }
    public boolean addCustomer(Customer customer) {
        if (total >= 0 && total < customers.length) {
            customers[total] = customer;
            total++;
            return true;
        }
        return false;
    }
    public boolean replaceCustomer(int index, Customer cust) {
        if (index >= 1 && index <= customers.length) {
            customers[index - 1] = cust;
            return true;
        }
        return false;
    }
    public boolean deleteCustomer(int index) {
        if (index >1 && index <= total) {
            int a = index - 1;
            for ( a = 0; a < total; a++) {
                customers[a] = customers[a + 1];
            }
            return true;
        }
        return false;
    }
    public Customer[] getAllCustomers() {
        Customer[] cus = new Customer[total];
        int a = total;
        for ( a = 0; a < total; a++) {
            cus[a] = customers[a];
        }
        return cus;
    }
    public Customer getCustomer(int index) {
       if (index > total || index < 0 ) {
           System.out.println("从0开始");
           return null;
       }
        return customers[index - 1];
    }
    public int getTotal () {
        return total;
    }

}
