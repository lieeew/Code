package Day25;

/**
 * 自定义的泛型类
 * @Auther: QiuXinYu
 * @Date: 2022/11/13 - 11 - 13
 * @Description: Day25
 */
public class Order<T> {
    String name;
    int age;

    // 自定义的泛型
    T orderT;

    public Order() {
    }

    public Order(String name, int age, T orderT) {
        this.name = name;
        this.age = age;
        this.orderT = orderT;
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

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", orderT=" + orderT +
                '}';
    }
}
