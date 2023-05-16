package Day27.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/19 - 11 - 19
 * @Description: Day27.exer
 */
public class WordCount {

    @Test
    public void test1() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file = new File("D:\\SOFT\\BaiduNetdiskDownload\\尚硅谷java\\1_课件\\第2部分：Java高级编程\\第2部分：Java高级编程\\尚硅谷_宋红康_第13章_IO流\\dbcp.txt");
            File desFile = new File("WordCount.txt");

            fr = new FileReader(file);

            Map<Character, Integer> map = new HashMap<Character, Integer>();

            int len;
            char[] chars = new char[5];
            while ((len = fr.read(chars)) != -1) {
                for (int i = 0; i < len; i++) {
                    char aChar = chars[i];
                    if ( ! map.containsKey(aChar)) {
                        map.put(aChar, 1);
                    } else {
                        map.put(aChar, map.get(aChar) + 1);
                    }
                }
            }
            fw = new FileWriter(desFile);
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Map.Entry<Character, Integer> set : entries) {
                switch (set.getKey()) {
                    case ' ':
                        fw.write("空格 = " + set.getValue() + "\n");
                        break;
                    case '\t':
                        fw.write("tab键 = " + set.getValue()+ "\n");
                        break;
                    case '\r': // 回车
                        fw.write("回车 = " + set.getValue()+ "\n");
                        break;
                    case '\n':
                        fw.write("换行 = " + set.getValue() +  "\n");
                        break;
                    default:
                        fw.write(set.getKey() + " = " + set.getValue() + "\n") ;
                        break;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null) fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fw != null) fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
