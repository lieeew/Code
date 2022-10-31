package Day21.study;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/29 - 10 - 29
 * @Description: Day21.study
 */
public class NewTimeApi {
    @Test
    public void test1() {
        // 会有偏移量
        Date date = new Date(2020 - 1900, 9 - 1, 20); // 日期需要减去1990 月份减去1
        System.out.println(date); // Wed Oct 20 00:00:00 CST 3920
    }

    /**
     * LocalDate LocalTime LocalDateTime
     *
     * 说明:
     *  1. LocalDateTime 使用的较多
     *
     */
    @Test
    public void test2() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);


        // 指定的时间, 没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 2, 2, 2, 2, 2);
        System.out.println(localDateTime1); // 2020-02-02T02:02:02
        System.out.println(localDateTime1.getYear());
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getHour());
        System.out.println(localDateTime1.getMinute());

        // getXxx() 获取相关的属相

        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue()); // 返回的是纯数字

        // withXxx() 设置相关的属性  体现了不可变性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        LocalDate localDate1 = localDate.withYear(2000);
        System.out.println(localDate);
        System.out.println(localDate1);


        // plusXxx()   增加
        // minusXxx()  减少

        LocalDate localDate2 = localDate.plusDays(4);
        System.out.println(localDate);
        System.out.println(localDate2);

        LocalDate localDate3 = localDate.minusMonths(1);
        System.out.println(localDate3);

    }
}
