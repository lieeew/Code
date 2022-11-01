package easyAlgorithms;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/29 - 09 - 29
 * @Description: easyAlgorithms
 */
class hwb {
    public static void main(String[] args) {
        String name = "李华";
        int age = 1;
        int sex = 1;
        System.out.println("姓名:" + name);
        //经过一年，年龄加一岁
        age = age + 1;
        System.out.println("年龄:" + age);

        if (sex == 1) {
            System.out.println("性别:男");
        } else {
            System.out.println("性别:女");
        }
    }
}