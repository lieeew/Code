package com.leikoooo.charpter2_reverselist.过关挑战;


/**
 * @author leikooo
 * @create 2023-07-21 9:30
 * @Package com.leikoooo.charpter1_link_test.过关挑战
 * @Description
 */
public class homework {

    public static ListNode helpOther(ListNode head) {
        ListNode dummySlow = new ListNode(-1);
        dummySlow.next = head;
        ListNode slow = dummySlow;

        ListNode dummyFast = new ListNode(-1);
        dummyFast.next = head;
        ListNode fast = dummyFast;

        while (fast.next != null && fast.next.next != null) {
            slow.next = fast.next;
            slow = slow.next;
            fast.next = fast.next.next;
            fast = fast.next;
        }

        slow.next = null;

        ListNode cur = reverse(dummyFast.next);
        slow = dummySlow.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = next;
            slow = slow.next.next;
        }

        return dummySlow.next;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public static void main(String[] args) {
        // 假如十位同学成绩分别是{1,2,3,4,5,6,7,8,9,10}
        // 编排的时候发现单数位置不变(1,3,5,7,9)，偶数位置(10,8,6,4,2)反转
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode listNode = helpOther(initLinkedList(a));
        System.out.println(toString(listNode));

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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
