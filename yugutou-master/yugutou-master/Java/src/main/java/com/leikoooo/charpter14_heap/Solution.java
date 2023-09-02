package com.leikoooo.charpter14_heap;

import com.leikoooo.tools.BinaryTree;
import com.yugutou.tools.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 创建一个最小堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }
        // 记录头节点
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        // 进行排序
        while (!priorityQueue.isEmpty()) {
            tail.next = priorityQueue.poll();
            tail = tail.next;
            if (tail.next != null) {
                priorityQueue.offer(tail.next);
            }
        }
        return dummy.next;
    }

    @Test
    public void test() {
        // 创建多个链表作为测试数据
        ListNode[] lists = new ListNode[3];

        // 第一个链表: 1 -> 4 -> 5
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        // 第二个链表: 1 -> 3 -> 6
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(6);

        // 第三个链表: 2 -> 4 -> 7
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(4);
        lists[2].next.next = new ListNode(7);

        Solution solution = new Solution();
        ListNode mergedList = solution.mergeKLists(lists);

        // 打印合并后的链表
        while (mergedList != null) {
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
    }
}


