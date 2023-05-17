package Day13exer.MarkDown;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/6 - 09 - 06
 * @Description: MarkDown
 */
public class EqualsTest {
    public static void main(String[] args) {

        Customer cus1 = new Customer(12, "lihua");
        Customer cus2 = new Customer(12, "lihua");
        System.out.println(cus1.equals(cus2)); //true

    }


}
class Customer {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Customer() {

    }

    public Customer(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Customer) {
            Customer cus = (Customer) obj;
            return cus.getName().equals(this.name) && cus.getAge() == this.age;
        }
        return false;
    }
}

