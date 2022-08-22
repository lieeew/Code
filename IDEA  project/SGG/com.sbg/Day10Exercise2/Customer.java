package Day10Exercise2;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/21 - 08 - 21
 * @Description: Day10Exercise2
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;
    public Customer (String f, String l) {
        firstName = f;
        lastName = l;
    }
    public String getFirstName () {
        return firstName;
    }
    public String getLastName () {
        return lastName;
    }
    public void setAccount (Account account) {
        this.account = account;
    }
    public Account getAccount () {
        return account;
    }

}
