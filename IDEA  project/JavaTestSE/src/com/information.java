package com;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/3 - 08 - 03
 * @Description: com
 */
public class information {
    private int age;
    private String name;
    private String sex;
    // 空构造器
    public information () {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void sexName (String name) {
        this.name = name;
    }
    public String getName () {
        return name;
    }
    public void sexSex (String sex) {
        if (sex.equals("男") || sex.equals("女")) {
            this.sex = sex;
        }else {
            this.sex = "男";
            System.out.println("请输入正确的姓名格式!");
        }
    }
    public String  getSex () {
        return sex;
    }
    public information (int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sexSex(sex);
    }

}

