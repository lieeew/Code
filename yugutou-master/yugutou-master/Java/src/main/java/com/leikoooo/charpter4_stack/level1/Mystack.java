package com.leikoooo.charpter4_stack.level1;

import java.util.Arrays;

/**
 * @author leikooo
 */
class Mystack<T> {
    //实现栈的数组
    private Object[] stack;
    //栈顶元素
    private int top;

    Mystack() {
        //初始容量为10
        stack = new Object[10];
    }

    /**
     * 判断是否为 null
     *
     * @return
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * 返回栈顶元素
     *
     * @return
     */
    public T peek() {
        T t = null;
        if (top > 0) {
            t = (T) stack[--top];
        }
        return t;
    }

    /**
     * 取出元素
     *
     * @return
     */
    public T pop() {
        T t = peek();
        if (top > 0) {
            stack[top] = null;
        }
        return t;
    }

    /**
     * 增加元素
     *
     * @param t
     */
    public void push(T t) {
        expandCapacity(stack.length);
        stack[top] = t;
        top++;
    }

    /**
     * 扩大容量
     *
     * @param size
     */
    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;//每次扩大50%
            stack = Arrays.copyOf(stack, size);
        }
    }

    public static void main(String[] args) {
        Mystack<String> stack = new Mystack<>();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        stack.push("language");
        stack.push("りゆ");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}