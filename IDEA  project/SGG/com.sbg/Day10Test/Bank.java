package Day10Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/20 - 08 - 20
 * @Description: Day10Test
 */
public class Bank {
    private Customer[] customers = new Customer[10];;
    private int numberofCustomers;
    public Bank () {
        //  customers = new Customer[10]; // 不进行此操作,会空指针

    }
    public void addCustomer (String f, String l) {
        Customer cus = new Customer(f,l);
        customers[numberofCustomers] = cus;
        numberofCustomers ++;
    }
    public int getNumberofCustomers () {
        return numberofCustomers + 1;
    }
    public Customer getCustomer (int index) {
        // return  customers[index]; 可能会有角标越界的情况
        if (index > numberofCustomers) {
            System.out.println("抱歉,查询无结果!");
            return  null;
        }else {
            return customers[index];
        }
    }
}
