package Day21.study;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/27 - 10 - 27
 * @Description: Day21.study
 */
public class IdeaDebug {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb); // null
        System.out.println(sb.length()); // 4

        StringBuffer sb2 = new StringBuffer(str); // 报错NullPointException
        System.out.println(sb2.length());
    }
}
