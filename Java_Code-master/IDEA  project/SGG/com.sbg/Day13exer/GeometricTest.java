package Day13exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/3 - 09 - 03
 * @Description: Day13exer
 */
public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();
        Circle c = new Circle("red", 1.0, 2.0);
        MyRectangle m = new MyRectangle("white", 2.0, 2.0, 3.0);

        test.displayGeometricObject(c);
        test.displayGeometricObject(m);

        boolean equalsArea = test.equalsArea(c, m);
        System.out.println("两个面积相等是:" + equalsArea);
    }


    public boolean equalsArea (GeometricObject o1, GeometricObject o2) {
        return o1.findArea() == o2.findArea();
    }
    public void displayGeometricObject (GeometricObject o) {
        double area = o.findArea();
        System.out.println("面积为" + area);
    }
}
