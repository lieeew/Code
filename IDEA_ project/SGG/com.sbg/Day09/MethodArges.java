package Day09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/13 - 08 - 13
 * @Description: Day09
 */
public class MethodArges {
    // 可变参数
    public static void main(String[] args) {
        MethodArges test = new MethodArges();
        test.show("aa","bb");

    }
    public void show (String...arges) {// 相当于String[] arges
        System.out.println("芜湖");
        for (int j = 0; j < arges.length;  j++) {
            System.out.println(arges[j]);
        }
    }
    public void show (int a, int... arges) { // 可变个数方法形参自能放在后面
        System.out.println();
    }
}
