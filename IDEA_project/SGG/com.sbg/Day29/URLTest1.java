package Day29;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/24 - 11 - 24
 * @Description: Day29
 */
public class URLTest1 {

    @Test
    public void test() {
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            URL url = new URL("http://localhost:8080/nvs.jpg");

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect(); // 此时才链接到服务器

            inputStream = urlConnection.getInputStream();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("nvs.jpg"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
