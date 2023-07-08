package com.yupi.user_center.service;

import org.junit.jupiter.api.Test;

/**
 * @author leikooo
 * @create 2023-07-06 21:46
 * @Package com.yupi.user_center.service
 * @Description
 */
public class ListNodeTest {
    /* 链表节点类 */
    class ListNode {
        int val;        // 节点值
        ListNode next;  // 指向下一个节点的指针（引用）

        ListNode(int x) {
            val = x;
        }  // 构造函数
    }

    @Test
    public void test() {
        /* 初始化链表 1 -> 3 -> 2 -> 5 -> 4 */
        // 初始化各个节点
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        // 构建引用指向
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
    }

}
