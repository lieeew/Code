package DAY08;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/10 - 08 - 10
 * @Description: DAY08
 */
// 改进StudentTest代码
public class StudentTest02 {
    public static void main(String[] args) {
        Student02[] stu = new Student02[20];
        for(int i = 0;i < stu.length;i++){
            //给数组元素赋值
             stu[i] =  new Student02();
            // 年级
            stu[i].state = (int) (Math.random() * 6 + 1);
            // 分数
            stu[i].score = (int) (Math.random() * 100);
            // 顺序
            stu[i].number = (i + 1);
        }
        StudentTest02 s = new StudentTest02();
        s.print(stu);
        System.out.println("***********");
        s.seartchState(stu, 3);
        System.out.println("**********");
        s.sort(stu);


    }

    /**
     * 查找
     *
     * @param stu
     * @param num
     */
    public  void seartchState(Student02[] stu, int num) {
        for (int a = 0; a < stu.length; a++) {
            if (num == stu[a].state) {
                System.out.println(stu[a]);
            }
        }
    }


    /**
     * 冒泡排序进行成绩的排序
     *
     * @param stu
     */
    public  void sort(Student02[] stu) { // 冒泡排序
        for (int a = 0; a < stu.length - 1; a++) {
            for (int j = 0; j < stu.length - 1 - a; a++) {
                if (stu[j].score > stu[j + 1].score) {
                    Student02 num = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = num;
                }
            }
        }
        for (int c = 0; c < stu.length; c++) {
            System.out.println("成绩为:" + stu[c].score + "\t年级:" + stu[c].state + "\t序号为" + stu[c].number);
        }
    }

    /**
     * 遍历数组
     *
     * @param stu
     */
    public  void print(Student02[] stu) {
        for (int a = 0; a < stu.length; a++) {
            System.out.println("成绩为:" + stu[a].score + "\t年级:" + stu[a].state + "\t序号为" + stu[a].number);
        }
    }
}
class Student02 {
    int number;
    int state;
    int score;

    public String inforr() {
        return "成绩为:" + score + "\t年级:" + state + "\t序号为" + number;
    }
}

