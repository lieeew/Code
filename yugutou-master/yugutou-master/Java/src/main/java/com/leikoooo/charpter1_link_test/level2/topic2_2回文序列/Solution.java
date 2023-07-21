package com.leikoooo.charpter1_link_test.level2.topic2_2回文序列;

import org.junit.jupiter.api.Test;

class Solution {
    
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }

    }


     public  ListNode initLinkList(int[] array) {
        ListNode head = null, cur = null;
        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = newNode;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 注意这边有两个指向的是同一个人链表
        ListNode pre1 = list1, post1 = list1, post2 = list2;
        int i = 0, j = 0;
        while (pre1 != null && post1 != null && j < b) {
            if (i < a - 1) {
                pre1 = pre1.next;
                i++;
            }

            if (j != b) {
                post1 = post1.next;
                j++;
            }
        }

        while (post2.next != null) {
            post2 = post2.next;
        }

        // 连接相关的节点
        // 下面有图片解析
        pre1.next = list2;
        post2.next = post1.next;

        return list1;
    }

    @Test
    public void test() {
        int[] ist1 = new int[]{0,1,2,3,4,5,6};
        int a = 2;
        int b = 5;
        int[] list2 = {1000000,1000001,1000002,1000003,1000004};

        ListNode listNode = mergeInBetween(initLinkList(ist1), a, b, initLinkList(list2));
        System.out.println(listNode);

    }
}