package Day31;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/4 - 12 - 04
 * @Description: Day31
 */
public class ClassLoad3 {
    public static void main(String[] args) {
        /*
        1. 加载B类, 并生成 B的Class对象 这里底层有上锁的机制, 可以保证在多线程时只会加载一份
        2. 链接 num = 0
        3. 初始化阶段  依次自动收集类中所有的静态变量的复制动作和代码块中的语句
            client {
                   num = 20;
                   static int num = 10;
            }
            最终num的值为10
         */
        System.out.println(A2.num);// 调用静态属性也进行类的加载
    }
}

class A2 {
    static {
        num = 20;
    }
    static int num = 10;

    public A2() {
        System.out.println("构造器被执行");
    }
}