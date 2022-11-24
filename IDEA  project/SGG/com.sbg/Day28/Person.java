package Day28;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/21 - 11 - 21
 * @Description: Day28
 */

import java.io.Serializable;

/**
 * 要求
 * 1. 实现implements java.io.Serializable
 * 2. 自定义一个序列号, 如果修改过那么系统自动生成的就会报错
 * 3. 属性必须是可以序列化的, 基本数据类型都是可序列化的
 *
 * 补充:
 * ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * 序列化(核心) : 允许把内存中的Java对象转换成平台无关的二进制流，从
 * 而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传
 * 输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原来的Java对象
 */
public class Person implements java.io.Serializable{
    private String name;
    private int age;

    private Account account;


    private static final long serialVersionUID = -6849794667710L;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Person(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                '}';
    }
}

class Account implements Serializable {
    private int amount;

    private static final long serialVersionUID = -6849754667710L;

    public Account(int amount) {
        this.amount = amount;

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                '}';
    }
}
