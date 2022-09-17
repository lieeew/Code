package Day15exer;

import java.util.Scanner;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/14 - 09 - 14
 * @Description: Day15exer
 */
public abstract class PayrollSystem extends Employee{


    public PayrollSystem(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入天:");
        int day = sc.nextInt();
        System.out.println("请输入月:");
        int month = sc.nextInt();

        Employee e1 [] = new Employee[2];
        MyDate today = new MyDate(1, 1, 1);
        MyDate SalariedDate = new MyDate(12, 12, 2010);
        MyDate HourlyDate = new MyDate(12, 5, 2010);

        e1[0] = new SalariedEmployee("lihau", 12, SalariedDate, 10000);

        e1[1] = new HourlyEmployee("meiemi",12, HourlyDate, 60, 200);

        for (int a = 0; a < e1.length; a++) {
            System.out.println(e1[a]);
            double salary = e1[a].earning();
            System.out.println("工资为:" + salary);

            if (day == e1[a].getBirthday().getMouth() && month == e1[a].getBirthday().getMouth()) {
                System.out.println("生日快乐,加工资");
            } else {
                System.out.println("快生日了");
            }
        }
    }
}
