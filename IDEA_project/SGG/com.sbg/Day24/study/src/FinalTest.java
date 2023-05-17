package Day24.study.src;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/11 - 11 - 11
 * @Description: Day24.study
 */
public class FinalTest {
    /**
     * 请把学生名与考试分数录入到集合中，并按分数显示前三名
     * 成绩学员的名字。
     */
    @Test
    public void test2() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    return -Integer.compare((Integer) o1, (Integer) o2);
                }
                throw new RuntimeException();
            }
        };
        Map StudentScore = new HashMap();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入学生的姓名:");
            String name = sc.next();
            System.out.println("请输入学生的成绩:");
            int score = sc.nextInt();
            StudentScore.put(score, name);
        }
//        Set set = StudentScore.keySet();
//        List integers = new ArrayList();
//        integers.addAll(set);
//        Iterator iterator1 = integers.iterator();
//        Collections.sort(integers, comparator);
//
//        while (iterator1.hasNext()) {
//            System.out.println(iterator1.next());
//            int sum = 0;
//            if (sum++ >= 3) {
//                break;
//            }
//        }

        Set entrySet = StudentScore.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
    /**
     * 请从键盘随机输入10个整数保存到List中，并按倒序、从大
     * 到小的顺序显示出来
     */
    @Test
    public void test1() {
        Scanner sc = new Scanner(System.in);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入需要比较的数字:");
            int a = sc.nextInt();
            arrayList.add(a);
        }
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    return -Integer.compare((Integer) o1, (Integer) o2);
                }
                throw new RuntimeException("请输入正确的格式");
            }
        };
        Collections.sort(arrayList, comparator);
        System.out.println(arrayList);

    }
}
