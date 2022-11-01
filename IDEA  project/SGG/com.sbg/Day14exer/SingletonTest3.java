package Day14exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/11 - 09 - 11
 * @Description: Day14exer
 */

/**
 * 饿汉式的其他写法
 */
public class SingletonTest3 {
    public static void main(String[] args) {

        Emo e1 = Emo.getInstance;
        Emo e2 = Emo.getInstance;
        System.out.println(e1 == e2);
        

    }

}

class Emo {
    private Emo () {

    }

    public static final  Emo getInstance = new Emo();

}
