package Day24.study.src;

import java.util.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/12 - 11 - 12
 * @Description: Day24.study.src
 */
public class SecondTest {
    public static void main(String[] args) {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof StudentScore && o2 instanceof StudentScore) {
                    StudentScore s1 = (StudentScore) o1;
                    StudentScore s2 = (StudentScore) o2;
                    return -Integer.compare(s1.getScore(), s2.getScore());
                }
                throw new RuntimeException();
            }
        };
        Set set = new TreeSet(com);
        Scanner sc = new Scanner(System.in);
        System.out.println("输入负数退出输入.");
        for (int i = 0; ; i++) {
            System.out.println("请输入姓名:");
            String name = sc.next();
            System.out.println("请输入成绩:");
            int score = sc.nextInt();
            if (score < 0) break;
            StudentScore studentScore = new StudentScore(name, score);
            set.add(studentScore);

        }

        System.out.println("成绩列表为:");
        for(Object obj : set) {
            StudentScore s = (StudentScore) obj;
            System.out.println(s.getName() + "-->" + s.getScore());
        }


        System.out.println("前三名:");
        int sum = 0;
        for(Object obj : set) {
            if (sum == 3) {
                break;
            }
            StudentScore s = (StudentScore) obj;
            System.out.println(s.getName() + "-->" + s.getScore());
            sum++;
        }
    }
}
