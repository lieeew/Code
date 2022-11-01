package Day14;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/10 - 09 - 10
 * @Description: Day14
 */

/**
 * 1. final 可以修饰的得结构 : 类 ,方法 , 变量
 *
 * 2. final 修饰类 不能被子类继承 "太监类" age : String System StringBuffer
 *
 * 3. final 修饰方法 不能被重写
 *
 * 4. final 修饰变量(大写) , 此时"变量"就变为常量
 * 可以用:
 * 显示初始化, 代码块初始化 , 构造器初始化
 *
 *
 * static final 用来修饰的, 可以称为全局常量
 */
public class FinalTest {
    final int WITH = 10;  // 大写 Ctrl+Shift+U

    public void doWith () {
        // with = 20;
    }

    public void emo (final int num ){
        System.out.println(num);
    }

    public static void main(String[] args) {

    }

}

 class  AA {
    public final void work () {

    }

}
class BB extends AA { // 重写需要有子父类的关系
//    public void work () {
//        System.out.println("你好");
//    }
}

