package Day09.Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/17 - 08 - 17
 * @Description: Day09.Exercise
 */
public class ValueTransfer {
    public static void main(String[] args) {
        String s = "hello";
        ValueTransfer test = new ValueTransfer();
        test.change(s);
        System.out.println(s);

    }
    public void change (String s) {
        String s1 = "hi~~";
        s = s1;

    }
}
