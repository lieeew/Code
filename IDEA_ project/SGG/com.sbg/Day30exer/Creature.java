package Day30exer;

import java.io.Serializable;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/25 - 11 - 25
 * @Description: Day30exer
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃饭");
    }




}
