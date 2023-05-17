package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/6 - 09 - 06
 * @Description: Day13
 */
public class InterviewTest {
    public static void main(String[] args) {

        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n); // true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); // false

    }
}

//
//        Object o1 = true ? new Integer(1) : new Double(2.0);
//        System.out.println(o1);
//       结果为1,0 ,首先回执行左边的代码new Integer(1),但是同时也需要将吧数字变成相对高级类型的(double)
