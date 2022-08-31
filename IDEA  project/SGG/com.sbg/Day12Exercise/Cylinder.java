package Day12Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/30 - 08 - 30
 * @Description: Day12Exercise
 */
public class Cylinder extends Circle {
    private double length;
    public Cylinder () {
        length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double findVolume () {// 求体积
        double area = super.findArea();
        return area * length;
    }

    @Override
    public double findArea() {

        return super.findArea() * 2 + Math.PI * getRadius() * 2 * getLength();
    }
}
