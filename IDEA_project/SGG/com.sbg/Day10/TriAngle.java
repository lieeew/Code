package Day10;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/17 - 08 - 17
 * @Description: Day10
 */
public class TriAngle {
    private double base;
    private double height;
    public TriAngle () {

    }
    public TriAngle (double a, double b) {
        base = a;
        height = b;
    }
    public void setBase (double base) {

        this.base = base;
    }
    public double getBase () {
        return base;
    }
    public void setHeight (double height) {

        this.height = height;
    }
    public double getHeight () {

        return height;
    }
    public void s (double base, double height) {
        double s = base * height;
        System.out.println(s);
    }
}
