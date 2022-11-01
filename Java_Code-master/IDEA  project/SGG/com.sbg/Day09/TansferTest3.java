package Day09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/14 - 08 - 14
 * @Description: Day09
 */
public class TansferTest3 {
    public static void main(String[] args) {
        TansferTest3 t = new TansferTest3();
        t.first();

    }
    public void first () {
        int i =5;
        Value v = new Value();
        v.i = 25;
        second(v,i);
        System.out.println(v.i + "   " + i);

    }
    public void second (Value v, int i) {
        i = 0;
        v.i = 20;
        Value v1 = new Value();
        v = v1;
        System.out.println(v.i + "   " + i);

    }
}
class Value {
    int i = 10;
}
