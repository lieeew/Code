package MarkdownTest02;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/14 - 09 - 14
 * @Description: MarkdownTest02
 */


public class BreakTest {
    public static void main(String[] args) {

        boolean isFlag = true;
        for (int a = 0; a < 10; a++) {
            if (a == 3) {
                continue;
            }
            if (a == 4) {
                isFlag = false;
                break;
            }
        }
        if (isFlag) {
            System.out.println("你好");
        }
    }
}