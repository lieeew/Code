package DoubleSort;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/5 - 08 - 05
 * @Description: com.sbgTest01
 */
public class ArraysTest {
    public static void main(String[] args) {
        // 查找(或搜索)
        String[] arr = new String[] {"JJ","MM","BB","GG","AA","DD"};
        String dest = "BB";
        boolean isflag = true;
        for (int a = 0; a < arr.length; a++) {
            if (arr[a].equals(dest)) {
                System.out.println("你要查找的序号为:" + (a + 1));
                isflag = false;
                break;
            }
        }
        if (isflag) {
            System.out.println("查无此数");
        }
    }
}
