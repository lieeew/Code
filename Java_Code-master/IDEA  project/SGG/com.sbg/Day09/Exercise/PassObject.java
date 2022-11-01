package Day09.Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/16 - 08 - 16
 * @Description: Day09.Exercise
 */
public class PassObject {
    public static void main(String[] args) {
        Cricl c = new Cricl();
        PassObject P = new PassObject();
        P.printAreas(c,5);
        System.out.println("Now radius is " + c.radius  );


    }
    public void printAreas (Cricl c, int time) { // Cricl 类型的,所以要创建一个对象
        System.out.println("Radius" + "\t\tArea");
        int a = 1;
        for (; a <= time; a++) {
            // 半径赋值
            c.radius = a;
            System.out.println(a + "\t\t\t" + c.findArea());
        }
        // c.radius = time + 1;
        c.radius = a ;  // a == 6 的时候不符合 a <= 5 所以循环结束

    }
}
