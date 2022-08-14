package Day09.Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/14 - 08 - 14
 * @Description: Day09.Exercise
 */
public class PassObject {
    public static void main(String[] args) {
        PassObject p = new PassObject();
        Cricle c = new Cricle();
        p.printAreas(c,4);
    }
    public void printAreas (Cricle c, int time) {
        System.out.println("Cricle" + "    "+ "s");
        for (int a = 0; a <= time; a ++) {
            c.redius = a;
            System.out.println(  a +"\t\t"+c.redius);
        }
    }
}
