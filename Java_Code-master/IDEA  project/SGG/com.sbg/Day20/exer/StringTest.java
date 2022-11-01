package Day20.exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/21 - 10 - 21
 * @Description: Day20.exer
 */
public class StringTest {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) { // 可以被修改
        str = "test ok"; // 原来的没有变化
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");//
        System.out.println(ex.ch);
    }
}

