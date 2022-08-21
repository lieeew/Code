package Day10Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/20 - 08 - 20
 * @Description: Day10Test
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;
    public Customer () {

    }

    public Customer (String f, String l) {
        firstName = f;
        lastName = l;
    }
    public String getFirstName () {

        return  firstName;
    }
    public  String getLastName () {

        return lastName;
    }
    public void setAccount (Account acct) {
        account = acct;
    }
    public Account getAccount () {
        return account;
    }
}
