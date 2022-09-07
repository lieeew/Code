package Day13exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/7 - 09 - 07
 * @Description: Day13exer
 */

import java.util.Scanner;
import java.util.Vector;

/**
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出
 * 最高分，并输出学生成绩等级。
 * 提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的
 * 长度。而向量类java.util.Vector可以根据需要动态伸缩。
 * 创建Vector对象：Vector v=new Vector();
 * 给向量添加元素：v.addElement(Object obj); //obj必须是对象
 * 取出向量中的元素：Object obj=v.elementAt(0);
 * 注意第一个元素的下标是0，返回值是Object类型的。
 * 计算向量的长度：v.size();
 * 若与最高分相差10分内：A等；20分内：B等；
 * 30分内：C等；其它：D等
 */
public class ScoreTest {
    public static void main(String[] args) {
        int MaxNum = 0;
        Scanner sc = new Scanner(System.in);
        for (;;){
            System.out.println("请录入学生成绩(以负数代表输入结束)");
            int score = sc.nextInt();
            if (score < 0 || score > 100) {
                System.out.println("非法数据");
                break;
            }
            Vector v = new Vector();
            v.addElement(score);
            if (score > MaxNum) {
                MaxNum = score;
            }
            char level = 0;
            for ( int a = 0; a < v.size(); a ++) {
                Object obj = v.elementAt(a);
                Integer num = (Integer) obj;
                int i = MaxNum - num; // 成绩差值
                if (i <= 10 ) {
                   level = 'A';
                } else if (i <= 20 ) {
                    level = 'B';
                } else if (i <= 30 ){
                    level = 'C';
                } else {
                    level = 'D';
                }
                System.out.println("Student-" + a + ", score is" + score + ", level is" + level);
            }
         }
    }
}
