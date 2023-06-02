package com.hspedu.Spring.component;

import com.hspedu.Spring.Annotation.Before;
import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.processor.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: HspBeanPostProcessor
 * Package: com.hspedu.Spring.processor
 *
 * @Author: leikooo
 * @Creat: 2023/5/30 - 21:57
 * @Description: 1. 这个是我们的后置处理器
 * 2. 实现了 BeanPostProcessor
 * 3. 我们可以重写 before和 after 方法
 * 4. 加@Component注解 需要加载到容器之中, HspBeanPostProcessor需要加入到容器之中才能工作
 * 5. 需要考虑多个后置处理器
 */
@Component
public class HspBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Class<?>> classCache = new HashMap<>();

    // 后置处理器是对容器之中创建的bean生效
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
//        if (bean instanceof Car) {
//            System.out.println("这个是一个car我要处理他~");
//        }

        // 假设我们知道切片类是 SmartAnimalAspect
        // 首先反射拿到类信息
        String methodName = "";
        String reflectName = "";

        Class<?> clazz = getClassFromCache("com.hspedu.Spring.component.SmartAnimalAspect");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Before.class)) {
                // 如果这个方法有 before 注解
                String path = method.getDeclaredAnnotation(Before.class).value();
                String name = getReflectName(path);
                reflectName = name.split("-")[0];
                methodName = name.split("-")[1];
            }
        }

        // 这个 SmartAnimal 是如何获取的, 这个问题就很有灵性
        Class<?> beanClass = bean.getClass();
        Class<?> aClass = getClassFromCache(reflectName);

        if (aClass.isAssignableFrom(beanClass)) {
            // 如果是这个类那么需要动态代理
            return createProxyInstance(bean, methodName);
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("postProcessBeforeInitialization 被调用" + beanName + "bean= " + bean.getClass());
        return bean;
    }

    private String getReflectName(String path) {
        // 解析切片类获取 reflectName 和 methodName
        String smallPath = path.substring(path.indexOf('(') + 1, path.lastIndexOf(')'));
        System.out.println("smallPath = " + smallPath);
        // 使用正则表达式提取类名
        Pattern pattern = Pattern.compile("([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*([a-zA-Z_$][a-zA-Z\\d_$]*)\\(");
        Matcher matcher = pattern.matcher(smallPath);

        // 找到匹配的类名
        String reflectName = null;
        String methodName = null;
        if (matcher.find()) {
            // 获取完整的类名（包括包路径）
            String fullClassName = matcher.group(0);
            reflectName = fullClassName.trim().substring(0, fullClassName.lastIndexOf('.'));

            // 获取最后一个点之后的类名（不包括包路径）
            methodName = matcher.group(2);
        }
        return reflectName + "-" + methodName;
    }

    private Object createProxyInstance(Object bean, String methodName) {
        return Proxy.newProxyInstance(
                bean.getClass().getClassLoader(), // 使用目标类的类加载器作为代理类的类加载器
                bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (methodName.equals(method.getName())) {
                            // 前置通知
                            SmartAnimalAspect.beforeLog();
                            Object result = method.invoke(bean, args);
                            // 后置通知
                            SmartAnimalAspect.afterLog();
                            return result;
                        } else {
                            Object result = method.invoke(bean, args);
                            return result;
                        }
                    }
                }
        );
    }

    private Class<?> getClassFromCache(String className) {
        Class<?> clazz = classCache.get(className);
        if (clazz == null) {
            try {
                clazz = Class.forName(className);
                classCache.put(className, clazz);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return clazz;
    }
}






