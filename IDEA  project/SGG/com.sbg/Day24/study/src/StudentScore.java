package Day24.study.src;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/11 - 11 - 11
 * @Description: Day24.study.src
 */
public class StudentScore {
    private String name;
    private int Score;

    public StudentScore(String name, int score) {
        this.name = name;
        Score = score;
    }

    public StudentScore() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentScore that = (StudentScore) o;

        if (Score != that.Score) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Score;
        return result;
    }
}
