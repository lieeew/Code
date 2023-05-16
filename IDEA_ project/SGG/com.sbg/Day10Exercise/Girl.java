package Day10Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/19 - 08 - 19
 * @Description: Day10Exercise
 */
public class Girl {
    private int age;
    private String name;
    public Girl () {

    }
    public Girl (String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void setName (String name) {
        this.name = name;
    }
    public String getName () {
        return  name;
    }
    public void marry (Boy boy) {
        System.out.println("我想嫁给" + boy.getName());
        boy.marry(this);
    }
    public void compare (Girl girl1) {
        if (age > girl1.age) {
            System.out.println(name + "大");
        }else if (age < girl1.age) {
            System.out.println(girl1.name + "大");
        }else {
            System.out.println("一样大");
        }
    }
}
