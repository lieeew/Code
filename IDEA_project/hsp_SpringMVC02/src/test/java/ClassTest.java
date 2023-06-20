import com.hspedu.hspspringmvc.annotation.RequestParam;
import com.hspedu.hspspringmvc.handler.HspHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author leikooo
 * @create 2023-06-19 14:52
 * @Package PACKAGE_NAME
 * @Description
 */
public class ClassTest {

    public static void main(String[] args) {
        // HspHandler hspHandler = new HspHandler();
        // Object instance = Class.forName("com.hspedu.Controller.MonsterController").newInstance();
        // hspHandler.setController();

        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.hspedu.Controller.MonsterController");
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                Annotation[][] parameterTypes = method.getParameterAnnotations();
                for (Annotation[] parameterType : parameterTypes) {
                    for (Annotation annotation : parameterType) {
                        if (annotation instanceof RequestParam) {
                            System.out.println("哈哈哈~~");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
