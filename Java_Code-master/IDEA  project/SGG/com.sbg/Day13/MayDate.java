package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/4 - 09 - 04
 * @Description: Day13
 */
public class MayDate {
    private int Day;
    private int Match;
    private int Year;

    public MayDate() {

    }

    public MayDate(int day, int match, int year) {
        Day = day;
        Match = match;
        Year = year;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getMatch() {
        return Match;
    }

    public void setMatch(int match) {

        Match = match;
    }

    public int getYear() {

        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MayDate) {
            MayDate mydate = (MayDate) obj;

            return mydate.Year == this.Year && mydate.Match == this.Match && mydate.Day == this.Day;
        }
        return false; // 不是mydate的子类,返回false;
    }
}

//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj instanceof MayDate) {
//            MayDate mydate = (MayDate) obj;
//            if (mydate.Day == this.Day && mydate.Match == this.Match
//                    && mydate.Year == this.Year) {
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }
//}



