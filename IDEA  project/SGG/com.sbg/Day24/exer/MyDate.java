package Day24.exer;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/9 - 11 - 09
 * @Description: Day24
 */
public class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate) {
            MyDate b = (MyDate) o;

            int DifferenceYear = this.year - b.getYear();
            int DifferenceMonth = this.month - b.month;
            if (DifferenceYear != 0) {
                return DifferenceYear;
            }
            if (DifferenceMonth != 0) {
                return DifferenceMonth;
            }
            return this.day - b.day;
        }
        throw new RuntimeException("请输入正确的类型");
    }
}
