package Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/14 - 09 - 14
 * @Description: Day15
 */
public class TemplateTest {
    public static void main(String[] args) {

        Template t = new subTemplate();
        t.spendTime();

    }
}

abstract class Template {

    public void spendTime () {
        long start = System.currentTimeMillis();

        this.code();

        long end = System.currentTimeMillis();

        System.out.println("花费的时间:" + (end - start));
    }

    public abstract void code();
}

class subTemplate extends Template {

    @Override
    public void code() {
        for (int a = 2; a <= 1000; a++){
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(a); j++) {
                if (a % j ==0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(a);
            }

        }

    }
}
