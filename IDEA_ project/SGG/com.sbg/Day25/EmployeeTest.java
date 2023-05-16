package Day25;

import Day24.exer.Employee;
import Day24.exer.MyDate;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/9 - 11 - 09
 * @Description: Day24
 */
public class EmployeeTest {

    @Test
    public void test2() {
        TreeSet<Day25.Employee> set = new TreeSet<>(new Comparator<Day25.Employee>() {
            @Override
            public int compare(Day25.Employee o1, Day25.Employee o2) {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                int MinYear = b1.getYear() - b2.getYear();
                if (MinYear != 0) {
                    return MinYear;
                }
                int MinMonth = b1.getMonth() - b2.getMonth();
                if (MinMonth != 0) {
                    return MinMonth;
                }
                return b1.getDay() - b2.getDay();
            }
        });

        Day25.Employee b1 = new Day25.Employee(12, "Lihua", new MyDate(2002, 12, 2));
//        Day25.Employee b2 = new Day25.Employee(14, "Jack", new MyDate(2001, 1, 3));
//        Day25.Employee b3 = new Day25.Employee(17, "Mick", new MyDate(2001, 1, 2));
        Day25.Employee b4 = new Day25.Employee(15, "Merry", new MyDate(2002, 12, 2));


        set.add(b1);
        set.add(b4);
//        set.add(b2);
//        set.add(b3);

//        Iterator<Day25.Employee> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        for(Day25.Employee e : set) {
            System.out.println(e);
        }

    }

    @Test
    public void test1() {
        Comparator<Day24.exer.Employee> com = new Comparator<Day24.exer.Employee>() {

            @Override
            public int compare(Day24.exer.Employee o1, Day24.exer.Employee o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        };
        // jdk7新特性
        TreeSet<Day24.exer.Employee> set = new TreeSet<>(com);
        Day24.exer.Employee e2 = new Day24.exer.Employee(15, "Tom", new Day24.exer.MyDate(2001, 2, 13));
        Day24.exer.Employee e3 = new Day24.exer.Employee(17, "Jack", new Day24.exer.MyDate(2003, 3, 12));
        Day24.exer.Employee e4 = new Day24.exer.Employee(34, "Qiu", new Day24.exer.MyDate(2001, 2, 14));
        Day24.exer.Employee e1 = new Employee(12, "LiHua", new MyDate(2001, 2, 13));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
