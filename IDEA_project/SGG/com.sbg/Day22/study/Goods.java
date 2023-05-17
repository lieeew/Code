package Day22.study;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/30 - 10 - 30
 * @Description: Day22.study
 */
public class Goods implements Comparable{

    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" + "name='" + name + '\'' + ", price=" + price + '}';
    }

    /**
     * 如果当前对象this大于形参对象obj，则返回正整数，
     * 如果当前对象this小于形参对象obj，则返回负整数，
     * 如果当前对象this等于形参对象obj，则返回零。
     * 按照价格从低到高排序
     * @param o the object to be compared。
     * @return
     */

    // 先按照价格来拍, 再按照名称排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods obj = (Goods) o;
            if (obj.price > this.price) return -1;
            if (obj.price < this.price) return 1;
            if (obj.price == this.price) {
                return this.name.compareTo(obj.name); // String类型实现了Comparable接口, 重写了compareTo()方法
            }
        }
        throw new RuntimeException("请输入Goods类型的变量");
    }
}
