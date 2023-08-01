package com.leikoooo.charpter5_queue_map;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TaskManager {
    Queue<String> newQueue;
    Queue<String> finishQueue;

    public TaskManager() {
        newQueue = new LinkedList<>();
        finishQueue = new LinkedList<>();
    }

    /**
     * 添加 Task
     * @param task 任务
     */
    public void addTask(String task) {
        newQueue.add(task);
    }

    /**
     * 完成任务
     */
    public void finishTask() {
        String task = newQueue.poll();
        if (task != null) {
            finishQueue.add(task);
        }
    }

    public void printTasks() {
        System.out.println("未完成的需求: " + newQueue.toString());
        System.out.println("已经完成的需求: " + finishQueue.toString());
    }
}