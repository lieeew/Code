package JavaTest;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/8 - 08 - 08
 * @Description: Test
 */
public class Find {
    public static void main(String[] args) {
        int[] arr = new int[] {34,5,22,-98,6,-76,0,-3};
        int num = 22;
        boolean isflage = true;
        for (int a = 0; a <arr.length; a++) {
            if (arr[a] == 666) {
                isflage = false;
                System.out.println("您要查找的序号为:" + a);
                break;
            }
        }
        if (isflage) {// a == arr.length;
            System.out.println("查无此数");
        }
    }
}
