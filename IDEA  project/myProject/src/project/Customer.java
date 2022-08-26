package project;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/26 - 08 - 26
 * @Description: project
 */
public class Customer {
    private int age;
    private String phone;
    private String email;
    private char sex;
    private String name;
// alt + insert 快速创建get,set方法
    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public char getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }
}
