package Day24.exer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/9 - 11 - 09
 * @Description: Day24
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    // 这个方式有点繁琐
                    /*if (e1.getBirthday().getYear() > e2.getBirthday().getYear()) {
                        return 1;
                    } else if ((e1.getBirthday().getYear() < e2.getBirthday().getYear())) {
                        return -1;
                    } else {
                        if (e1.getBirthday().getMonth() > e2.getBirthday().getMonth()) {
                            return 1;
                        } else if (e1.getBirthday().getMonth() < e2.getBirthday().getMonth()) {
                            return -1;
                        } else {
                            if (e1.getBirthday().getDay() > e2.getBirthday().getDay()) {
                                return 1;
                            } else if(e1.getBirthday().getDay() < e2.getBirthday().getDay()) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }*/
                    // 简洁一些的方法:方法一:
                    /*MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    int DifferenceYear = b1.getYear() - b2.getYear();
                    if (DifferenceYear != 0) {
                        return DifferenceYear;
                    }
                    int DifferenceMonth = b1.getMonth() - b2.getMonth();
                    if (DifferenceMonth != 0) {
                        return DifferenceMonth;
                    }
                    int DifferenceDay = b1.getDay() - b2.getDay();
                    return DifferenceDay;*/

                    // 方式二
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    return b1.compareTo(b2);
                }
                throw new RuntimeException("请输入正确的类型");
            }
        };
        TreeSet set = new TreeSet(com);
        Employee e2 = new Employee(15, "Tom", new MyDate(2001, 2, 13));
        Employee e3 = new Employee(17, "Jack", new MyDate(2003, 3, 12));
        Employee e4 = new Employee(34, "Qiu", new MyDate(2001, 2, 14));
        Employee e1 = new Employee(12, "LiHua", new MyDate(2001, 2, 13));
        set.add(e2); // 添加顺序和是否能加上有关系
        set.add(e1);
        set.add(e3);
        set.add(e4);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
