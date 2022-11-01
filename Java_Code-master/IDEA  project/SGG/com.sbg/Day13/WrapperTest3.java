package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/6 - 09 - 06
 * @Description: Day13
 *
 *
 */


public class WrapperTest3 {
    public static void main(String[] args) {

        // 基本数据转化为String 类型

        int num = 10;
        // 方式一 连接运算
        String s1 = num + "";

        // 方式二 调用String 类型的 valueOf ()
        float f1 = 12.9f;
        String s = String.valueOf(f1);
        System.out.println(s);


        // String转化为基本数据类型

        String str = "123";
        int i = Integer.parseInt(str);
        System.out.println(i + 1);


    }
}
