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
        int index = a.getNum(arr,39);
        if (index == -1) {
            System.out.println("没找到");
        }else {
            System.out.println("找到了:" + index );
        }
        //a.Sort(arr);// 这个方法调完之后arr数组就变为了排序后的arr
        System.out.println(a.getAverrage(arr));
        System.out.println(a.getMax(arr));
        System.out.println(a.getMine(arr));
        a.Sort(arr);
        a.reverse(arr);
    }
}
