package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/6 - 09 - 06
 * @Description: Day13
 */

/**
 *
 * println 除了char形数组可以输出内容其他的都是地址值
 */
public class PrintlnTest {

    public static void main(String[] args) {
        Integer integer = new Integer(1);
        System.out.println(integer);

        char [] arr = {'a', 'b', 'c'};
        System.out.println(arr);

        int[] arr1 = {12,12,34,55};
        System.out.println(arr1);
    }
}
