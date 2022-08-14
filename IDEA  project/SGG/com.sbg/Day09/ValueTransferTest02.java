package Day09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/13 - 08 - 13
 * @Description: Day09
 */
public class ValueTransferTest02 {
    public static void main(String[] args) {
        Date w = new Date();
        w.m = 10;
        w.n = 20;
        System.out.println(w.m + "    "+ w.n );
        ValueTransferTest02 test = new ValueTransferTest02();
        test.change(w);

        System.out.println(w.m +"    " +  w.n);

    }
    public void change(Date a) {  //    Date类型的数据
        int temp = a.m;
        a.m = a.n;
        a.n = temp;
}
}
class Date {
    int m ;
    int n ;
}