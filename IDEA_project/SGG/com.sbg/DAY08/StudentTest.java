package DAY08;


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
           stu[a].state = (int)(Math.random() * (6 - 1 + 1) + 1);
           // 成绩
           stu[a].score = (int)(Math.random() * (100 - 0 + 1));
       }// 遍历
       for (int a = 0; a < stu.length; a++) {
            System.out.println(stu[a].infor() ); // 遍历数组
            // System.out.println(stu[1]); // DAY08.Student@4554617c  引用类型要不存null 要不是地址
            }
        System.out.println("**************");
        for (int a = 0; a < stu.length; a++) {
           if (stu[a].state == 3) {
               System.out.println("成绩为:" + stu[a].score + "\t年级:" + stu[a].state + "\t序号为" + stu[a].number);// 遍历
           }
        }
        System.out.println("************");
        for (int a = 0; a < stu.length - 1; a++) {
            for (int j = 0; j < stu.length - 1 - a; j++) {
                if (stu[j].score > stu[j + 1].score) {
                    Student num = stu[j]; // 如果要换顺序,换的不只是成绩
                    stu[j] = stu[j + 1];
                    stu[j + 1] = num;
                }
            }
        }
        for (int c = 0; c < stu.length; c ++) {
            System.out.println(stu[c].infor());
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
}
