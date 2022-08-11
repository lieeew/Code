package Day09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/11 - 08 - 11
 * @Description: Day09
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] arr = {14,39,666,23,15,39,89,4556,544,33,22,11};
        ArraysUtil a = new ArraysUtil();
        a.Sort(arr);
        System.out.println(a.getAverrage(arr));
        System.out.println(a.getMax(arr));
        System.out.println(a.getSmall(arr));
    }
}
