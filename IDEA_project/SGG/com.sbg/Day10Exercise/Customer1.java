package Day10Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/19 - 08 - 19
 * @Description: Day10Exercise
 */
public class Customer1 {
    private String firstName;
    private String lastName;
    private Account account;
    public Customer1() {

    }
    public Customer1(String f,String l) {
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
