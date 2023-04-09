package com.hspedu.ThreadLoacal;

/**
 * @Author: qxy
 * @Date: 2023/4/9
 * @Description:
 */
public class T1 {
    // 创建ThreadLocal1 对象
    public static ThreadLocal<Object> threadLocal1 = new ThreadLocal<>();
    public static ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(new Task()).start(); // 主线程中启动了一个新的线程
    }

    public static class Task implements Runnable{
        @Override
        public void run() {
            Dog dog = new Dog();
            Pig pig = new Pig();
            // 给threadLocal1
            threadLocal1.set(dog);
            threadLocal2.set(pig);
            /*
            public void set(T value) {
                // 1. 获取当前的线程, 关联到当前的线程
                Thread t = Thread.currentThread();
                // 2. ThreadLocalMap 的类型是 ThreadLocal.ThreadLocalMap
                ThreadLocalMap map = getMap(t);
                // 3. 如果 map不为null 就将value放入 map-key: threadLocal value: 存放的数据
                // 一个ThreadLocal 只能关联一个数据, 如果再次set() 就会替换
                // 4. 如果map == null , 就根据创建一个当前线程关联的ThreadLocal1Map
                if (map != null) {
                    map.set(this, value);
                } else {
                    createMap(t, value);
                }
            }
             */

            /*
             get方法
             public T get() {
                // 1. 获取当前线程的名称
                Thread t = Thread.currentThread();
                // 2. 通过这个线程的名称取出 ThreadLocalMap
                ThreadLocalMap map = getMap(t);
                if (map != null) {
                    // 3. 如果这个map不为空, 根据当前的treadLocal 对象, 得到对应的Entry
                    ThreadLocalMap.Entry e = map.getEntry(this);
                    // 4. 如果e不为null
                    if (e != null) {
                        @SuppressWarnings("unchecked")
                        T result = (T)e.value;
                        return result;
                    }
                }
                return setInitialValue();
            }

             */
            System.out.println("Task 名称 = " + Thread.currentThread().getName() + " dog = " + threadLocal1.get());
            new T1Service().update();
        }
    }
}
