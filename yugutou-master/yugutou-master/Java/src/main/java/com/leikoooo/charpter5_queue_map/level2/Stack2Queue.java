package com.leikoooo.charpter5_queue_map.level2;

import java.util.Stack;

/**
 * @author leikooo
 * @create 2023-07-30 22:15
 * @Package com.leikoooo.charpter5_queue_map.level2
 * @Description 使用栈实现队列
 */
public class Stack2Queue {
    Stack<Integer> stackBefore = new Stack<>();
    Stack<Integer> stackAfter = new Stack<>();

    public Stack2Queue() {

    }

    /**
     * 入队列
     *
     * @param x 值
     */
    public void push(int x) {
        // 先放到 before 这个栈里面
        stackBefore.push(x);
    }

    public int pop() {
        // 出栈的时候先把 stackAfter 填满
        in2Out();
        return stackAfter.pop();
    }

    public int peek() {
        if (stackAfter.isEmpty()) {
            in2Out();
        }
        return stackAfter.peek();
    }

    public boolean empty() {
        return stackAfter.isEmpty() && stackBefore.isEmpty();
    }

    private void in2Out() {
        while (!stackBefore.isEmpty()) {
            stackAfter.push(stackBefore.pop());
        }
    }
}
