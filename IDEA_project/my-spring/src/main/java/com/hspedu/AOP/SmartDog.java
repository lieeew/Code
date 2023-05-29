package com.hspedu.AOP;

import org.springframework.stereotype.Component;

/**
 * ClassName: SmartDog
 * Package: com.hspedu.AOP
 *
 * @Author: leikooo
 * @Creat: 2023/5/29 - 5:49
 * @Description:
 */
@Component
public class SmartDog implements SmartAnimal{
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
