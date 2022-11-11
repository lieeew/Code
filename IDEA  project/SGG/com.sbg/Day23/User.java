package Day23;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/7 - 11 - 07
 * @Description: Day23
 */
public class User implements Comparable{
    private String name;
    private int age;

    public User() {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            if (user.name == this.name) {
                return user.age - this.age;
            } else {
                return user.name.compareTo(this.name);
            }
        }
        throw new RuntimeException("输入的对象不符合规范");
    }
}