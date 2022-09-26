package Day16;

import java.io.IOException;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/26 - 09 - 26
 * @Description: Day16
 */
public class OverrideTest {

    public static void main(String[] args) {
        superClass s = new subClass();
        OverrideTest test = new OverrideTest();
        test.display(new subClass());
    }

    public void display (superClass s) {
        try {
            s.method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


class superClass {
    public void method() throws IOException {

    }
}

class subClass extends superClass {
    public void method () { // 子类方法抛出的异常可以比父类抛出的异常小(小到极限为无)

    }
}