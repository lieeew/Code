package MarkdownTest02;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/17 - 09 - 17
 * @Description: MarkdownTest02
 */
public class c {

}

interface A {

    int x = 0;
}

class B {

    int x = 1;
}

class C extends B implements A {

    public void px () {
        // System.out.println(x); 输出x
        System.out.println(super.x);
        System.out.println(A.x); // 因为A类中的x是全局的, 前省略public static final
    }

    public static void main(String[] args) {

        new C().px();
    }
}