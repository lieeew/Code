package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/5 - 09 - 05
 * @Description: Day13
 */
public class Circle extends GeometricObject{
    private double radius;

    public Circle() {
        super();
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Circle) {
            Circle circle = (Circle) obj;
            return circle.radius == this.radius;
        }
        return false;
    }

    public String toString() {
        return "[ Radius =  " + radius +"]";
    }





}
