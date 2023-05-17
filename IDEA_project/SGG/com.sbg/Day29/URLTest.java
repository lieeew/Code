package Day29;

import java.io.IOException;
import java.net.URL;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/23 - 11 - 23
 * @Description: Day29
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/nvs.jpg");

//        public String getProtocol( ) 获取该URL的协议名
        System.out.println(url.getProtocol());
//        public String getHost( ) 获取该URL的主机名
        System.out.println(url.getHost());
//        public String getPort( ) 获取该URL的端口号
        System.out.println(url.getPort());
//        public String getPath( ) 获取该URL的文件路径
        System.out.println(url.getPath());
//        public String getFile( ) 获取该URL的文件名
        System.out.println(url.getFile());
//        public String getQuery( ) 获取该URL的查询名
        System.out.println(url.getQuery());

    }
}

