package easyAlgorithms;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/31 - 10 - 31
 * @Description: easyAlgorithms
 */
public class a1 {
    // "2019-2-30" 变成java.sql.Date

    @Test
    public void test1() throws ParseException {
        String str = "2019-2-3";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        java.sql.Date date1 = new java.sql.Date(date.getTime());


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TemporalAccessor parse = dtf.parse(str);

    }
}
