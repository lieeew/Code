package Day24.study;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/10 - 11 - 10
 * @Description: Day24.study
 */
public class Person implements Comparable{
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            int i = this.name.compareTo(p.name);
            if (i != 0) {
                return -i;
            }
            return -Integer.compare(p.id, this.id);
        }
        throw new RuntimeException("请输入正确的类型");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
