package MarkDown;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/7 - 09 - 07
 * @Description: MarkDown
 */
public class bbb {
    public static void main(String[] args) {

        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i + 1);

        // 但是,如果不是纯数字会报错
//        String str2 = "123AS";
//        int i2 = Integer.parseInt(str2);
//        System.out.println(i2); // NumberFormatException

        String str3 = "true12";
        boolean b = Boolean.parseBoolean(str3);
        System.out.println(b); //false
    }
}
