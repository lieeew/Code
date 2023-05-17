package Day15exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/18 - 09 - 18
 * @Description: Day15exer
 */
public class Circle {

    private double Redius;

    public Circle(double redius) {
        Redius = redius;
    }

    public double getRedius() {
        return Redius;
    }

    public void setRedius(double redius) {
        Redius = redius;
    }


}


class ComparableCircle extends Circle implements CompareObjec {
    public ComparableCircle(double redius) {
        super(redius);
    }


//    public ComparableCircle(Circle circle) {
//        this.circle = circle;
//    }

    @Override
    public int compareTo(Object o){
        if (o == this) {
            return 0;
        }
        if (o instanceof ComparableCircle) {
            ComparableCircle circle = (ComparableCircle) o;
            if (this.getRedius() > circle.getRedius()) {
                return 1;
            } else if (this.getRedius() == circle.getRedius()) {
                return 0;
            } else if (this.getRedius() < circle.getRedius()) {
                return -1;
            }
        }
        return 0;
    }
}

class InterfaceTest {
    public static void main(String[] args) {

        ComparableCircle c1 = new ComparableCircle(2.9);
        ComparableCircle c2 = new ComparableCircle(3.9);
        int compareNum = c2.compareTo(c1);
        if (compareNum > 0 ) {
            System.out.println("前者大");
        } else if (compareNum < 0) {
            System.out.println("后者大");
        } else {
            System.out.println("一样大");
        }
    }
}



