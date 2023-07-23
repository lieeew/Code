package com.leikoooo.charpter2_reverselist.level2.topic_2_4链表加法;

import com.yugutou.charpter1_linklist.level1.ListNode;

import java.util.Stack;

/**
 * 两个链表相加
 */
public class ReverseList_AddList {
    public static void main(String[] args) {
        int[] a = {9, 3, 7};
        ListNode nodeA = initLinkedList(a);
        int[] b = {6, 3};
        ListNode nodeB = initLinkedList(b);

        ListNode d = null;
        int testMethod = 2;
        switch (testMethod) {
            case 1://方法1：通过栈实现
                d = addInListByStack2(nodeA, nodeB);
                break;
            case 2://方法2：通过链表反转来实现
                d = addInListByReverse(nodeA, nodeB);
                break;

        }


        System.out.println(toString(d));

    }

    /**
     * 通过栈来实现
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInListByStack(ListNode head1, ListNode head2) {
        Stack<ListNode> st1 = new Stack<ListNode>();
        Stack<ListNode> st2 = new Stack<ListNode>();
        while (head1 != null) {
            st1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            st2.push(head2);
            head2 = head2.next;
        }
        ListNode newHead = new ListNode(-1);
        int carry = 0;
        //这里设置carry!=0,是因为当st1,st2都遍历完时，如果carry=0,就不需要进入循环了
        while (!st1.empty() || !st2.empty() || carry != 0) {
            ListNode a = new ListNode(0);
            ListNode b = new ListNode(0);
            if (!st1.empty()) {
                a = st1.pop();
            }
            if (!st2.empty()) {
                b = st2.pop();
            }
            //每次的和应该是对应位相加再加上进位
            int get_sum = a.val + b.val + carry;
            //对累加的结果取余
            int ans = get_sum % 10;
            //如果大于0，就进位
            carry = get_sum / 10;
            ListNode cur = new ListNode(ans);
            cur.next = newHead.next;
            //每次把最新得到的节点更新到neHead.next中
            newHead.next = cur;
        }
        return newHead.next;
    }

    /**
     * 通过栈来实现
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInListByStack2(ListNode head1, ListNode head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        // 将元素放入到栈中
        while (head1 != null) {
            stack1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.val);
            head2 = head2.next;
        }

        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        while (!stack1.empty() || !stack2.empty() || carry != 0) {
            Integer num1 = null;
            Integer num2 = null;
            if (stack1.empty()) {
                num1 = 0;
            } else {
                num1 = stack1.pop();
            }
            if (stack2.empty()) {
                num2 = 0;
            } else {
                num2 = stack2.pop();
            }
            int digital = num1 + num2 + carry;
            carry = digital >= 10 ? 1 : 0;
            digital = digital >= 10 ? digital - 10 : digital;
            ListNode node = new ListNode(digital);
            node.next = dummyNode.next;
            dummyNode.next = node;
        }
        return dummyNode.next;
    }

    /**
     * 方法2：通过链表反转来实现
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInListByReverse(ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int val = carry;
            if (head1 != null) {
                val += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                val += head2.val;
                head2 = head2.next;
            }
            carry = val / 10;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return reverse(head.next);
    }

    private static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    /**
     * 方法2：通过链表反转来实现
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInListByReverse2(ListNode head1, ListNode head2) {
        // 定义两个「指针」
        ListNode cur1 = reverse(head1);
        ListNode cur2 = reverse(head2);

        ListNode dummyNode = new ListNode(-1);
        int carry = 0;

        while (cur1 != null || cur2 != null || carry != 0) {
            ListNode node1 = new ListNode(0);
            ListNode node2 = new ListNode(0);
            if (cur1 != null) {
                node1 = cur1;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                node2 = cur2;
                cur2 = cur2.next;
            }

            int digital = node2.val + node1.val + carry;
            carry = digital >= 10 ? 1 : 0;
            digital = digital % 10;
            ListNode listNode = new ListNode(digital);
            listNode.next = dummyNode.next;
            dummyNode.next = listNode;
        }
        return dummyNode.next;
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
