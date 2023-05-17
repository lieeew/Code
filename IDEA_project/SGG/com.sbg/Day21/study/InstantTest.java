package Day21.study;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/30 - 10 - 30
 * @Description: Day21.study
 */
public class InstantTest {

    @Test
    public void test1() {
        // 这个是本初子午线的时间
        Instant instant = Instant.now();
        System.out.println(instant);

        // 需要添加偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        // 获取时间戳   --> 类似于Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        //  ofEpochMilli通过制定的毫秒数取得对应的instant的实例   --> 类似于 Date(long mills);
        Instant instant1 = Instant.ofEpochMilli(7823231123l);
        System.out.println(instant1);
    }

    /**
     * DateTimeFormatter
     * 1.  预定义的标准格式。如:ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
     * 2.  本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
     * 3.  自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
     *
     */
    @Test
    public void test2() {
        // 预定义的标准格式。如:ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化  Date -- > String
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = isoLocalDateTime.format(localDateTime);
        System.out.println(format);
        System.out.println(LocalDateTime.now());

        // 解析 String --> Date  字符创-->日期
        TemporalAccessor parse = isoLocalDateTime.parse("2022-10-30T12:48:55.398"); // 因为不确定是否为什么类型,就用接口接收
        System.out.println(parse);

        // FormatStyle.LONG, FormatStyle.MEDIUM, FormatStyle.SHORT
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String format1 = dateTimeFormatter.format(localDateTime);
        System.out.println(format1);


        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String parse1 = dateTimeFormatter1.format(localDateTime);
        System.out.println(parse1);

        //方式三 自定义类 最常用
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        // 格式化 Date --> String
        String format2 = dateTimeFormatter2.format(LocalDateTime.now());
        System.out.println(format2);

        // 解析 String --> Date
        TemporalAccessor parse2 = dateTimeFormatter2.parse("2022-10-30 01:22:59");
        System.out.println(parse2);
    }
}
