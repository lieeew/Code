package com.leikoooo.charpter5_queue_map.level2;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author leikooo
 * @create 2023-07-31 9:19
 * @Package com.leikoooo.charpter5_queue_map.level2
 * @Description
 */
public class Queue2Stack {
    /**
     * 输入队列
     */
    Queue<Integer> inQueue;
    /**
     * 输出队列
     */
    Queue<Integer> outQueue;

    public Queue2Stack() {
        inQueue = new LinkedList<>();
        outQueue = new LinkedList<>();
    }

    public void push(int x) {
        inQueue.offer(x);
        while (!outQueue.isEmpty()) {
            inQueue.offer(outQueue.poll());
        }
        Queue<Integer> temp = outQueue;
        outQueue = inQueue;
        inQueue = temp;
    }

    public int pop() {
        return outQueue.poll();
    }

    public int top() {
        return outQueue.peek();
    }

    public boolean empty() {
        return outQueue.isEmpty();
    }
}
