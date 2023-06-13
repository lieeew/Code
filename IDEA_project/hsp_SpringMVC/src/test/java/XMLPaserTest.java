import com.hspedu.hspspringmvc.XML.XMLPaser;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

/**
 * ClassName: XMLPaserTest
 * Package: PACKAGE_NAME
 *
 * @Author: leikooo
 * @Creat: 2023/6/12 - 13:53
 * @Description:
 */
public class XMLPaserTest {

    @Test
    public void test01() {
        XMLPaser xmlPaser = new XMLPaser();
        XMLPaser.getBasePackage("hspSpringMVC.xml");
        System.out.println("hello");
    }
}
