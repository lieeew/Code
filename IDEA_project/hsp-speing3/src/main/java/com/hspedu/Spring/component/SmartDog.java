package com.hspedu.Spring.component;


import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.processor.InitializingBean;

/**
 * ClassName: SmartDog
 * Package: com.hspedu.AOP
 *
 * @Author: leikooo
 * @Creat: 2023/5/29 - 5:49
 * @Description:
 */
@Component("smartDog")
public class SmartDog implements SmartAnimal {
    @Override
    public float getSum(float i, float j) {
        float result = i + j;
        System.out.println("smartDog-getSum-res " + result);
        return result;
    }


    @Override
    public float getSub(float i, float j) {
        float result = i - j;
        System.out.println("smartDog-getSub-res " + result);
        return result;
    }

}
