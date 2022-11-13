package Day25;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/9 - 11 - 09
 * @Description: Day24
 */
public class MyDate implements Comparable<MyDate> {
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
    public int compareTo(MyDate o) {
        int MinYear = o.getYear() - this.year;
        if (MinYear != 0) {
            return MinYear;
        }
        int MinMonth = o.getMonth() - this.month;
        if (MinMonth != 0) {
            return MinMonth;
        }

        return day - o.getDay();
    }
}
