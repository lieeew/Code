package Day12Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/30 - 08 - 30
 * @Description: Day12Exercise
 */
public class Circle {
    private double radius;
    public Circle () {
        radius = 1;
    }
    public void setRadius (double radius) {

        this.radius = radius;
    }
    public double getRadius () {
        return radius;
    }
    public double findArea () {
        return radius * radius * Math.PI;
    }
}
