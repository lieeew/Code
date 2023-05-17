package Day22.study;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/31 - 10 - 31
 * @Description: Day22.study
 */

import org.junit.Test;

/**
 * 对于枚举类
 * 1. 枚举类的理解 : 类的对象只有有限个,确定的. 我们称之为枚举类
 * 2. 需要定义=一组常量时, 强烈建议使用枚举类
 * 3. 如果如果枚举类中的对象那个只有一个,则可以作为单例实现方式
 *
 * 枚举类的常用方法:
 *  1   values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *  2.  valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符
 * 串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException
 * 3    toString()：返回当前枚举类对象常量的名称
 *
 */


public class SeasonTest {
    public static void main(String[] args) {
        Season season = Season.AUTUMN;
        System.out.println(season);

        Season1 season1 = Season1.AUTUMN;
        System.out.println(season1);
        // System.out.println(Season1.class.getSuperclass());
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        Season1 season11 = Season1.valueOf("WINTER"); // 可以把一个字符串转为对应的枚举类对象
        System.out.println(season11);
    }

    @Test
    public void test1() {
        Thread.State[] values = Thread.State.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        Thread.State aNew = Thread.State.valueOf("NEW");
        System.out.println(aNew);
    }
}

class Season {
    // 1 声明sean对象的属性
    private final String SeasonName;
    private final String SeasonDec;

    // 2 私有化构造器  ,并给对象赋值
    private Season(String seasonName, String seasonDec) {
        SeasonName = seasonName;
        SeasonDec = seasonDec;
    }

    // 3 提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "鸟语花香");
    public static final Season WINTER = new Season("冬天", "冰天雪地");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");

    public String getSeasonName() {
        return SeasonName;
    }

    @Override
    public String toString() {
        return "Season{" +
                "SeasonName='" + SeasonName + '\'' +
                ", SeasonDec='" + SeasonDec + '\'' +
                '}';
    }

    public String getSeasonDec() {
        return SeasonDec;
    }
}


interface off {
    void show();
}
/**
 *enum 的直接父类是 java.lang.Enum
 */
enum Season1 implements off{
    // 提供当前枚举类的多个对象 之间用逗号, 最后用分号结尾
    SPRING("春天", "春光花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里?");
        }
    },
    SUMMER("夏天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("夏天在哪里?");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("冬天在哪里?");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天在哪里?");
        }
    };

    private final String SeasonName;
    private final String SeasonDec;

    private Season1(String seasonName, String seasonDec) {
        SeasonName = seasonName;
        SeasonDec = seasonDec;
    }

//    @Override
//    public void show() {
//        System.out.println("你好啊");
//    }
}