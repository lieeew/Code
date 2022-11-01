package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/4 - 09 - 04
 * @Description: Day13
 */
public class Order {
    private int orderld;

    private String orderName;

    public int getOrderld() {
        return orderld;
    }

    public void setOrderld(int orderld) {
        this.orderld = orderld;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Order(int orderld, String orderName) {
        this.orderld = orderld;
        this.orderName = orderName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Order) {
            Order od = (Order) obj;
//            if (od.orderld == this.orderld && od.orderName.equals(this.orderName)) {
//                return true;
//            }
            if (od.orderld == od.orderld && od.orderName == od.orderName){ // String 比较特殊,String存储在方法区的常量池里面,如果内容一样那么就会变成同一地址
                return true;
            }
            return false;
        }
        return false;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        Order order = (Order) o;
//        return orderld == order.orderld && Objects.equals(orderName, order.orderName);
//    }

    public static void main(String[] args) {
        Order o1 = new Order(12, "lihua");
        Order O2 = new Order(12, "lihua");
        System.out.println(o1.equals(O2));
    }
}
