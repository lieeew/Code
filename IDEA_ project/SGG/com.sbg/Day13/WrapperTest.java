package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/6 - 09 - 06
 * @Description: Day13
 */
public class WrapperTest {
    public static void main(String[] args) {
        // 基本数据类型转化为包装类
        int num = 10;
        Integer num1 = new Integer(num);
        System.out.println(num1.toString());

        Integer num2 = new Integer("123456");
        System.out.println(num2);

//        Float float1 = new Float("123l"); // NumberFormatException
//        System.out.println(float1);

        Float float1 = new Float(123.4);
        Float float2 = new Float(123.777f);
        System.out.println(float1);
        System.out.println(float2);

        String s = "123abc";
        Boolean aBoolean = new Boolean(s);
        System.out.println(aBoolean); // false

        Emo order = new Emo();

        System.out.println(order.isMale);// false

        System.out.println(order.IsMan); // null

        // 包装类转化为基本数据类形, 用 ...Value 方法

        Integer integer = new Integer(123);
        int i = integer.intValue();
        System.out.println(i + 2);

        Float float4 = new Float("12.5");
        float v = float4.floatValue();
        System.out.println(v + 10);


    }
}

class Emo {

    boolean isMale;
    Boolean IsMan;

}

