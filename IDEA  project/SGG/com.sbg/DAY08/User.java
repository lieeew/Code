package DAY08;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/9 - 08 - 09
 * @Description: DAY08
 */
public class User {
    String name;
    String language;
    boolean iamale;
    int age;
    public User () {

    }
    public User (int age) {
        this.age = age;
    }
    public void talk (String language) {
        System.out.println("我们使用" + language + "交流");
    }

    public static void main(String[] args) {
        User u = new User(14);
        System.out.println(u.age);
        u.talk("日语");
        u.language = "芜湖";
        System.out.println(u.language);
    }
}
