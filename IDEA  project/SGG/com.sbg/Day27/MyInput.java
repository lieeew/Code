package Day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/20 - 11 - 20
 * @Description: Day27
 */
public class MyInput {
    public static void main(String[] args) {

    }
}
class Tool {
    public static String getString() throws IOException {
        System.out.println("进入系统:");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();

    }

    public int getInteger() throws IOException {
        return Integer.parseInt(getString());
    }

    public double getDouble() throws IOException {
        return Double.parseDouble(getString());
    }

    public long getLong() throws IOException {
        return Long.parseLong(getString());
    }

    public boolean getBoolean() throws IOException {
        return Boolean.parseBoolean(getString());
    }

}