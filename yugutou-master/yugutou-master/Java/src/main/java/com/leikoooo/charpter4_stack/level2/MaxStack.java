package com.leikoooo.charpter4_stack.level2;

import org.junit.jupiter.api.Test;

import java.util.Stack;

class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) {
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
    }

    @Test
    public void test() {
        MaxStack maxStack1 = new MaxStack();
        maxStack1.push(2);
        maxStack1.push(1);
        maxStack1.push(5);
        maxStack1.push(9);
        maxStack1.push(0);

        maxStack1.peekMax();
        maxStack1.popMax();

    }
}