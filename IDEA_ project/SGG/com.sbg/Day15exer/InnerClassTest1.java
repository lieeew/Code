package Day15exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/19 - 09 - 19
 * @Description: Day15exer
 */
public class InnerClassTest1 {
    public static void  main(String[] args) {
        // 少见
//        public void method () {
//
//            class AA {
//
//            }
//        }



    }
    // 返回一个事项了Comaprable接口的对象
    public Comparable getComparable () {

//        class MyComparable implements Comparable{
//
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//        return new MyComparable();
        // 方式二  匿名对象的匿名实现类
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
