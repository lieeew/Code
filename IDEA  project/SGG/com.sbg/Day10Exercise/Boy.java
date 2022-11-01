package Day10Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/19 - 08 - 19
 * @Description: Day10Exercise
 */
public class Boy {
    private String name;
    public Boy () {

    }
    public Boy (String name, int age) {
        this.age = age;
        this.name = name;
    }
    private int age;
    public void setName (String name) {
        this.name = name;
    }
    public String getName () {
        return name;
    }
    public void setAge (int aage) {
        this.age = age;
    }
    public int getAge () {
        return age;
    }
    public void marry (Girl girl) {
        System.out.println("我想娶" + girl.getName());
    }
    public void shout (Boy boy ) {
        int age = boy.getAge();
        if (age > 18) {
            System.out.println("ok");
        }else {
            System.out.println("no");
        }
    }
}
