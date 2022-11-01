package Day21.study;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/27 - 10 - 27
 * @Description: Day21.study
 */

import org.junit.Test;
import sun.util.resources.cldr.ro.CalendarData_ro_MD;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * jdk 8之前的API测试
 * 1. java.util.Date
 * 2. java.sql.Date
 * 3. SimpleDateFormat  SimpleDateFormat是对日期Date类的格式化和解析
 * 4.Calender
 */
public class DateTimeTest {




    @Test
    public void test1() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);
        // 格式化  Date --> 字符串
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        // 解析   字符串 --> Date (对于格式有严格的要求)
        Date parse = simpleDateFormat.parse("21-10-28 上午7:05"); // 格式必须一致
        System.out.println(parse);
        // 按照指定的方式格式化和解析, 可以调用SimpleDateFormat的带参数的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 格式化  Date --> 字符串
        String format1 = sdf1.format(date);
        System.out.println(format1);
        // 按照指定的方式格式化和解析, 可以调用SimpleDateFormat的带参数的构造器
        Date parse1 = sdf1.parse("2010-10-18 12:20:59");
        System.out.println(parse1);


    }

    /**
     * 把日期"2020-12-29" 转化为java.sql.Date
     */

    @Test
    public void test2() throws ParseException {
        String str = "2020-12-29";
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = spf.parse(str);
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date.toString()); // 这个结果为 2020-12-29 因为这个调用了toString()方法
    }

    /**
     *     练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？
     *
     *     举例：2020-09-08 ？ 总天数
     *
     *     总天数 % 5 == 1,2,3 : 打渔
     *     总天数 % 5 == 4,0 : 晒网 // 不可能会出现5, 因为会整除的, 所以 0就是第五天的时候
     *
     *     总天数的计算？
     *     方式一：( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
     *     方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08 这里可以调用Calendar中的get(Calendar.DAY_OF_YEAR)
     *     可以输出这一天在这一年的天数
     */
    @Test
    public void test3() throws ParseException {
        // 方式一:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年");
        String yy = sc.next();
        System.out.println("请输入月");
        String mm = sc.next();
        System.out.println("请输入日");
        String dd = sc.next();

        String str = yy + "-" + mm + "-" + dd;
        System.out.println(str);
        // 这个是把输入的日期转化为对应的毫秒数
        Date parse = sdf.parse(str);
        long time = parse.getTime();
        // 把 1990-01-01 这个变成毫秒数
        Date parse1 = sdf.parse("1990-01-01");
        long time1 = parse1.getTime(); // 变成毫秒(时间戳)
        long l = (time - time1) / (1000 * 60 * 60 * 24) + 1; // 这个计算会抹掉小数所以需要加一
        if (l % 5 >= 1 && l % 5 <= 3 ) {
            System.out.println("打渔");
        }
        if (l % 5 == 4 || l % 5 == 0) {
            System.out.println("晒网");
        }
    }

    @Test
    public void test4() {
        // 方式二
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1990-01-18";
        Date date = new Date();
        String format = sdf.format(date);
//        System.out.println(date);
//        System.out.println(format);
        // 开始时间
        int begine = Integer.parseInt(str.substring(0, 4));
        int endTime = Integer.parseInt(format.substring(0, 4));
        int month = (Integer.parseInt(str.substring(5, 7)) - Integer.parseInt(str.substring(5, 7))) * 30;
        int day = Integer.parseInt(format.substring(8)) - Integer.parseInt(str.substring(8));
        // 总共的天数
        int total = (endTime - begine) * 365 + month + day;
        if (total % 5 >= 1 && total % 5 <= 3 ) {
            System.out.println("打渔");
        } else {
            System.out.println("晒网");
        }
    }

    /**
     * 方式三
     * 利用Calendar 获取这一天在一年的第几天
     */
    @Test
    public void test6() {
        String str = "1990-01-01";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String SdfDate = sdf.format(date);
        int dd = Integer.parseInt(SdfDate.substring(8, 10));
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.DAY_OF_MONTH, dd);
        int TotalDay = instance.get(Calendar.DAY_OF_YEAR);
        int TotalYear1 = Integer.parseInt(SdfDate.substring(0, 4));
        int TotalYear2 = Integer.parseInt(str.substring(0, 4));
        int DayOfYear = (TotalYear1 - TotalYear2) * 365;
        int realTotal = TotalDay + DayOfYear;
        int i = realTotal % 5;
        if (i >= 1 && i <= 3) {
            System.out.println("打鱼");
        } else {
            System.out.println("晒网");
        }
    }

    /**
     * Calendar 日历类
     */
    @Test
    public void test5() {
        // 1.创建Calendr的对象, 但是Calender是abstract不能造对象
        // 方式一: 创建子类的对象 GregorianCalendar

        /*GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add();*/

        // 方式二: 直接调用Calender的静态方法 getInstance()
        Calendar instance = Calendar.getInstance(); // 这个instance依然是通过 GregorianCalendar 创建的
        // System.out.println(instance.getClass()); // java.util.GregorianCalendar

        // get()
        int day = instance.get(Calendar.DAY_OF_MONTH);
        int year = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println(day);
        System.out.println(year);

        //set()
        instance.set(Calendar.DAY_OF_MONTH, 24); // 设置
        int days = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        // add()
        instance.add(Calendar.DAY_OF_MONTH, 2);// 可以增加负数,相当于减去几天
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));

        // getTime()  获取当前时间
        Date time = instance.getTime();
        System.out.println(time);

        // setTime() 设置时间
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.getTime());
    }
}
