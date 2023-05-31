package com.hspedu.Spring.component;

import com.hspedu.Spring.Annotation.Component;

/**
 * ClassName: SmartAnimalAspect
 * Package: com.hspedu.Spring.component
 *
 * @Author: leikooo
 * @Creat: 2023/5/31 - 17:49
 * @Description:
 */
@Component
public class SmartAnimalAspect {

    public static void beforeLog() {
        System.out.println("前置通知~");
    }

    public static void afterLog() {
        System.out.println("后置通知~");
    }

}

