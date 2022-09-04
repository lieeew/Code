package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/4 - 09 - 04
 * @Description: Day13
 */
public class Customer {
    private int age;
    private String name;

    public Customer() {
    }

    public Customer(int age, String name) {
        this.age = age;
        this.name = name;
    }

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

    @Override
    public boolean equals(Object obj) {
        System.out.println("=============");
        if (this == obj) {
            return true;
        }
        if (obj instanceof Customer) {
            Customer cus = (Customer) obj;
            if (cus.age == this.age && cus.name.equals(this.name)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
