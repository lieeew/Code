package DAY08;


import java.util.Arrays;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/10 - 08 - 10
 * @Description: DAY08
 */
public class StudentTest {
    public static void main(String[] args) {
       Student[] stu = new Student[20];
       for (int a = 0; a < 20; a++) {
           stu[a] = new Student();
           stu[a].number = a + 1;
           // 年级1到6
           stu[a].state = (int)(Math.random() * 10 - 2);
           // 成绩
           stu[a].score = (int)(Math.random() * 10 + 10);
       }for (int a = 0; a < stu.length; a++) {
            System.out.println(stu[a].infor() ); // 遍历数组
            // System.out.println(stu[1]); // DAY08.Student@4554617c  引用类型要不存null 要不是地址
            }
        System.out.println("**************");
        for (int a = 0; a < stu.length; a++){
           if (stu[a].state == 3) {
               System.out.println("成绩为:" + stu[a].score + "\t年级:" + stu[a].state + "\t序号为" + stu[a].number);// 遍历
           }
        }
    }
}
class Student {
    int number;
    int state;
    int score;
    public String infor () {
        return  "成绩为:" + score + "\t年级:" + state + "\t序号为" + number;
    }
    public void sort (int[] num) {// 冒泡排序
        for (int b = 0; b < num.length; b++) {
            for (int a = 0; a < num.length - 1 - b; a++) {
                if (num[a] > num[a+1]) {
                    int m = num[a+1];
                    num[a + 1] = num[a];
                    num[a] = m;
                }
            }
        }
        System.out.println(Arrays.toString(num));
    }
}
