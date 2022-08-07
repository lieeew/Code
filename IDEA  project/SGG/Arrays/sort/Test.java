package sort;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/6 - 08 - 06
 * @Description: com.sbgDoubleSort
 */
public class Test {// 冒泡排序
    public static void main(String[] args) {
        int[] arr = new int[] {43,32,76,90,0,64,-21,29};
        for (int a = 0; a < arr.length - 1; a++) {
            for (int j = 0; j < arr.length - 1 - a; j++) {
                if (arr[j] > arr[j + 1]) {
                    int c = 0;
                    c = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = c;
                }else {
                    int b = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = b;
                }
            }
            }
        for (int c = 0; c < arr.length; c++) {
            System.out.print(arr[c] + "\t") ;
        }
    }
}
