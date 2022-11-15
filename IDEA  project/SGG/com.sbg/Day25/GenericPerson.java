package Day25;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/15 - 11 - 15
 * @Description: Day25
 */
public class GenericPerson {
    public static void main(String[] args) {
        Person1<Contact> p1 = new Person1<>(new Contact("local", "10086", "10001"));

        Person1<Introduction> p2 = new Person1<>(new Introduction("LiHua", "男", 12));



    }
}

interface info {

}
class Contact implements info {
    private String address ;	// 联系地址
    private String telephone ;	// 联系方式
    private String zipcode ;	// 邮政编码

    public Contact() {
    }

    public Contact(String address, String telephone, String zipcode) {
        this.address = address;
        this.telephone = telephone;
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}

class Introduction implements info {
    private String name ;		// 姓名
    private String sex ;		// 性别
    private int age ;			// 年龄

    public Introduction() {
    }

    public Introduction(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Introduction{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}

class Person1 <T extends info> {
    private info example;

    public Person1(info example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "example=" + example +
                '}';
    }
}