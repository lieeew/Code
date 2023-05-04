package com.hspedu.furns.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: qxy
 * @Date: 2023/4/17
 * @Description:
 */
public class DataUtils {

    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 转化字符串变成数字
     */
    public static int parseInt(String val, int defaultValue) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            // System.out.println(val + "的格式不正确 ~~");
        }
        return defaultValue;
    }
}
