package Day13exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/3 - 09 - 03
 * @Description: Day13exer
 */
public class GeometricObject {
    protected String color;
    protected double weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public double findArea () {
        return 0.0;
    }
}
