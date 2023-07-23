package com.leikoooo.charpter2_reverselist.level2.topic2_3链表加1;

import java.util.List;
import java.util.Stack;

/**
 * LeetCode369 单链表加1
 */
public class PlusOne {
    public static void main(String[] args) {
//        int[] a = {9, 9, 9};
        int[] a = {1, 2, 3};
        int num = 2;
        ListNode node = null;
        switch (num) {
            case 1:
                ListNode nodeA = initLinkedList(a);
                node = plusOne(nodeA);
                break;
            case 2:
                node = addOne(initLinkedList(a));
                break;
        }
        System.out.println(toString(node));

    }

    public static ListNode plusOne(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode dummyNode = new ListNode(-1);
        int adder = 1;
        int carry = 0;

        while (!stack.empty() || carry != 0 || adder != 0) {
            int dist = stack.empty() ? 0 : stack.pop();
            int sum = dist + adder + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode cur = new ListNode(sum);
            cur.next = dummyNode.next;
            dummyNode.next = cur;
            adder = 0;
        }

        return dummyNode.next;

    }

    public static ListNode plusOne2(ListNode head) {
        Stack<Integer> stack = new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int carry = 0;
        ListNode dummy = new ListNode(0);
        int adder = 1;
        while (!stack.empty() || adder != 0 || carry > 0) {
            int digit = stack.empty() ? 0 : stack.pop();
            int sum = digit + adder + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode listNode = new ListNode(sum);
            listNode.next = dummy.next;
            dummy.next = listNode;
            adder = 0;
        }
        return dummy.next;
    }

    /**
     * 使用链表反转
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 利用链表反转实现 加法
     */
    public static ListNode addOne(ListNode head) {
        ListNode node = reverse(head);
        int carry = 0;
        int adder = 1;
        ListNode cur = node;
        while (carry != 0 || adder != 0) {
            if (cur.val == 10 - adder && cur.next == null) {
                cur.next = new ListNode(0);
            }
            int digital = cur.val + adder + carry;
            // 大于 10 进 1
            carry = digital >= 10 ? 1 : 0;
            digital = digital >= 10 ? digital - 10 : digital;
            cur.val = digital;
            cur = cur.next;
            adder = 0;
        }
        return reverse(node);
    }


    /**
     * 初始化链表
     *
     * @param array
     * @return
     */
    private static ListNode initLinkedList(int[] array) {
        ListNode head = null, cur = null;

        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }


    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
