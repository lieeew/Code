package Day13exer.MarkDown;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/7 - 09 - 07
 * @Description: MarkDown
 */
public class WrapperTest {
    public static void main(String[] args) {
        // 调用构造器
        Integer int1 = new Integer(10);
        System.out.println(int1.toString());// Integer重写了toString 方法, 输出"实际值"
        Integer int2 = new Integer("12"); //也可以输入String类型
        System.out.println(int2.toString());// 12
        Integer int3 = new Integer("1234abc"); // 只能输入纯数字, 否则运行时报错 :NumberFormatException
        System.out.println(int3);

        Float f1 = new Float(13);
        System.out.println(f1.toString()); // 13.0

        // boolean
        Boolean b1 = new Boolean(true);
        System.out.println(b1.toString()); // true

        Boolean b2 = new Boolean("true123"); // 可以输入其他类型,不会报错
        System.out.println(b2); // false

    }
}
