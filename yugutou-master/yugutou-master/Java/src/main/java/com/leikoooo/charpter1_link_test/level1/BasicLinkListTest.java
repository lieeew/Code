package com.leikoooo.charpter1_link_test.level1;


import com.yugutou.charpter1_linklist.level1.BasicLinkList;

/**
 * @author leikooo
 * @create 2023-07-16 22:25
 * @Package com.leikoooo.charpter1_link_test.level1
 * @Description
 */
public class BasicLinkListTest {
    static class Node {
        final int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node = initLinkList(new int[]{1, 2, 3, 4, 5});
        String string = toString(node);
        System.out.println("string = " + string);
        int length = getLength(node);
        System.out.println("length = " + length);
        Node insertNode = insertNode(node, new Node(200), 3);
        node = initLinkList(new int[]{1, 2, 3, 4, 5});
        Node node1 = deleteNode(node, 1);
        node = initLinkList(new int[]{1, 2, 3, 4, 5});
        Node node2 = deleteNode(node, 4);
    }

    /**
     * 输出 node 的值
     *
     * @param head 头节点
     * @return 数据
     */
    public static String toString(Node head) {
        Node cur = head;
        if (cur == null) {
            return "";
        }
        // 线程安全的 StringBuilder
        StringBuilder sb = new StringBuilder();
        while (cur.next != null) {
            sb.append(cur.data).append("\t\t");
            // 指针向后
            cur = cur.next;
        }
        return sb.toString();
    }

    /**
     * 初始化数组
     *
     * @param array 数组对象
     * @return 链表
     */
    public static Node initLinkList(int[] array) {
        Node head = null, cur = null;
        for (int i = 0; i < array.length; i++) {
            Node newNode = new Node(array[i]);
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

    /**
     * 链表插入
     *
     * @param head       链表头节点
     * @param nodeInsert 待插入节点
     * @param position   待插入位置，取值从2开始
     * @return 插入后得到的链表头节点
     */
    public static Node insertNode(Node head, Node nodeInsert, int position) {
        // 先判断头节点是否为 null
        if (head == null) {
            return nodeInsert;
        }
        // 判断插入的位置
        int size = getLength(head);
        // 这里的边界条件有点意识，需要注意这里是 size + 1 意识就是 size + 1 也能够插入到链表之中
        if (position > size + 1 || position < 1) {
            System.out.println("插入的数组越界！");
            return head;
        }
        //需要插入头节点
        if (position == 1) {
            nodeInsert.next = head;
            head = nodeInsert;
            return head;
        }
        int index = 1;
        Node current = head;
        while (index < position - 1) {
            current = current.next;
            index++;
        }
        nodeInsert.next = current.next;
        current.next = nodeInsert;

        return head;
    }

    /**
     * 获取链表长度
     *
     * @param head 链表头节点
     * @return 链表长度
     */
    public static int getLength(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     * 删除节点
     *
     * @param head     链表头节点
     * @param position 删除节点位置，取值从1开始
     * @return 删除后的链表头节点
     */
    public static Node deleteNode(Node head, int position) {
        if (head == null) {
            return null;
        }
        if (position > getLength(head)  || position < 1) {
            return head;
        }
        Node current = head;
        // 如果索引是 1 的话
        if (position == 1) {
            head = current.next;
            return head;
        }
        int index = 1;
        while (index < position - 1) {
            current = current.next;
            index++;
        }
        current.next = current.next.next;
        return head;
    }
}
