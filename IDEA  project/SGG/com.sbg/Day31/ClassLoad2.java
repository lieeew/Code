package Day31;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/4 - 12 - 04
 * @Description: Day31
 */
public class ClassLoad2 {
    public static void main(String[] args) {
    }
}

class A1 {
    // 属性-成员变量-字段
    // 加载的缝接阶段-准备属性是如何处理
    // 1. n1 是属性实例, 不是静态变量, 因此在准备阶段, 是不会分配内存
    // 2. n2 是静态变量, 分配内存n2 是默认初始化 0, 而不是20
    // 3. n3 是 static final 时常量, 一次性分配内存并赋值为30, 一旦赋值就不会变化
    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;
}