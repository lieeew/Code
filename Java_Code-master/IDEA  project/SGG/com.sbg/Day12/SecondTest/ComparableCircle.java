package Day12.SecondTest;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/18 - 09 - 18
 * @Description: SecondTest
 */
public class ComparableCircle extends Circle implements CompareObject{

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle) o;
            if (c.getRadius() > this.getRadius()) {
                return -1;
            } else if (c.getRadius() < this.getRadius()) {
                return 1;
            } else {
                return 0;
            }
        }
        throw new RuntimeException("数据类型错误");
    }
}
