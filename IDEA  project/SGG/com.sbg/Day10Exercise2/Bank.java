package Day10Exercise2;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/21 - 08 - 21
 * @Description: Day10Exercise2
 */
public class Bank {
    private Customer[] customers = new Customer[10];
    private int numberOfCustomers;
    public Bank () {

    }
    public void addCustomer (String f, String l) {
        Customer cus = new Customer(f,l);
        customers[numberOfCustomers] = cus;
        numberOfCustomers ++;
    }
    public Customer getCustomer (int index) {
        if (index < numberOfCustomers) {
            return customers[index];
        }else {
            return null;
        }
    }
    public int getNumberOfCustomers () {
        return  numberOfCustomers;
    }
}
