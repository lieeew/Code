package DAY08.Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/9 - 08 - 09
 * @Description: DAY08.Exercise
 */
public class ExerciseTest {
    public static void main(String[] args) {
        ExerciseTest test = new ExerciseTest();
        test.methond(12,12);
    }
 /*   public void methond () {
        for (int a = 0; a < 10; a++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("*" + "\t");
            }
        System.out.println();
        }*/
    public int methond (int m , int n) {
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        return m * n;
    }
}
