package Day15exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/14 - 09 - 14
 * @Description: Day15exer
 */
public class MyDate {

    private int day;
    private int mouth;
    private int year;

    public MyDate(int day, int mouth, int year) {
        this.day = day;
        this.mouth = mouth;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//        if (obj instanceof MyDate) {
//            MyDate mydate = (MyDate) obj;
//            return mydate.getDay() == this.getDay() && mydate.getYear() == this.getYear()
//                    && mydate.getMouth() == this.getMouth();
//        }
//        return false;
//    }

    public String toDateString () {
        return year + "年, " + mouth + "月, " + day + "日";
    }
}
