package SecondTest;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/20 - 09 - 20
 * @Description: SecondTest
 */
public class SingleTest{
    public static void main(String[] args) {
        singleton s1 = singleton.getinstance();
        singleton s2 = singleton.getinstance();
        System.out.println(s1 == s2);

        AA a1 = AA.getInstance();
        AA a2 = AA.getInstance();
        System.out.println(a1 == a2);
    }
}


class singleton {
    private singleton () {

    }

    private static singleton s = new singleton();

    public static singleton getinstance () {
        return s;
    }
}

class AA {

    private  AA () {

    }

    private static AA aa = null;

    public static AA getInstance() {
        if (aa == null) {
            aa = new AA();

        }
        return aa;
    }
}