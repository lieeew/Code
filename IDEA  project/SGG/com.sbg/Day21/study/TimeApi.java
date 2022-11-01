package Day21.study;

import org.junit.Test;

import java.util.Date;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/24 - 10 - 24
 * @Description: Day21.study
 */

/**
 * jdk8之前的测试
 */

public class TimeApi {

    /**
     * java.util.Date类（父类）
     *    |--> java.sql.Date类(子类)
     *
     *  1.  两个构造器
     *    > 构造器一: 创建了一个当前时间的Date对象
     *    > 构造器二: 构造器二: 创建指定时间的Date对象

     *  2.  两个方法
     *    > toString() 显示当前的 年 月 日
     *    > getTime()  获取当前对象对应的时间戳
     *  3. java.sql.Date 对应数据库中日期类型的变量
     *   情况一: java.sql.Date转化为java.util.Date的对象  -- > 多态
     *   情况二: java.util.Date 转为 java.sql.Date的对象
     *      情况一:   Date date3 = new java.sql.Date(3298233l);
     *               java.sql.Date date4 = (java.sql.Date)date3;
     *
*           情况二: (new两个完全不关的对象是不可能可以强转的)
     *          Date date6 = new Date();
     *          java.sql.Date date5 = new java.sql.Date(date6.getTime());
     *
     */

    @Test
    public void test2() {
        // 构造器一: 创建了一个当前时间的Date对象
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime();

        // 构造器二: 创建指定时间的Date对象
        Date date2 = new Date(13123121l);
        System.out.println(date2.toString());


        Date date3 = new java.sql.Date(3298233l);
        java.sql.Date date4 = (java.sql.Date)date3;

        Date date6 = new Date();
        java.sql.Date date5 = new java.sql.Date(date6.getTime());
    }



    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        // 1970年1月1日0时0分0秒之间以毫秒为单位的时间差 称为时间戳
        System.out.println(time);
    }
}
