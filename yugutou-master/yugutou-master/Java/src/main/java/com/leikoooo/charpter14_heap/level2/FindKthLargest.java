package com.leikoooo.charpter14_heap.level2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            // 看一眼，不拿出，因为有可能没有必要替换
            Integer topEle = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topEle) {
                minHeap.poll();
                // minHeap.offer(nums[i]) 作用是将当前遍历到的元素加入到最小堆中
                // 同时会触发堆的调整操作，保证堆中的元素仍然保持最小堆的性质
                minHeap.offer(nums[i]);
            }
        }
        // 最小堆的时候头节点就是所需要的节点
        return minHeap.peek();
    }

    public static int findKthLargestTwo(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        // 创建一个最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (a, b) -> a - b);
        // 创建堆
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        // 数组长度
        int len = nums.length;
        // 循环遍历
        for (int i = k; i < len; i++) {
            Integer peek = priorityQueue.peek();
            if (nums[i] > peek) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.peek();
    }
}
