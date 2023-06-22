import com.hspedu.hspSpringMVC.annotation.Service;

/**
 * @author leikooo
 * @create 2023-06-21 18:23
 * @Package PACKAGE_NAME
 * @Description
 */
public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException {
        //  com.hspedu.Service.HspMonsterService
        Class<?> aClass = Class.forName("com.hspedu.Service.HspMonsterService");
        if (aClass.isAnnotationPresent(Service.class)) {
            System.out.println("hahah");
        }
    }
}
