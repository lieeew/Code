package Day33;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *
 * 二、数组引用
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    // Employee的空参构造器 new Employee()
    @Test
    public void test1(){
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

        // Lambda
        Supplier<Employee> supplier1 = () -> new Employee();
        supplier1.get();

        System.out.println("************");

        // 构造方法引用

        Supplier<Employee> supplier2 = Employee::new;
        supplier2.get();
	}

	//Function中的R apply(T t)
    // public Employee (int id)
    @Test
    public void test2(){
        Function<Integer, Employee> function = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer id) {
                return new Employee(id);
            }
        };
        // Lambda表达式
        Function<Integer, Employee> function1 = id -> new Employee(id);
        System.out.println(function.apply(1001));

        System.out.println("*****************");

        Function<Integer, Employee> function2 = Employee::new;
        System.out.println(function.apply(1001));
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer, String, Employee> biFunction = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer integer, String s) {
                return new Employee(integer, s);
            }
        };

        // Lambda
        BiFunction<Integer, String, Employee> biFunction1 = (id, name) -> new Employee(id, name);
        System.out.println(biFunction1.apply(1001, "Tom"));

        System.out.println("******************");

        BiFunction<Integer, String, Employee> biFunction2 = Employee::new;
        System.out.println(biFunction2.apply(1001, "Jack"));


    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer, String[]> function = length -> new String[length];
        String[] arr1 = function.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("****************");

        Function<Integer, String[]> function1 = String[]::new;
        String[] arr2 = function1.apply(10);
        System.out.println(Arrays.toString(arr2));
    }
}
