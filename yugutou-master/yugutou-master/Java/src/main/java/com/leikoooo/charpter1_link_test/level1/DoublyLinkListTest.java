package com.leikoooo.charpter1_link_test.level1;

import com.yugutou.charpter1_linklist.level1.DoublyLinkList;

/**
 * @author leikooo
 * @create 2023-07-17 19:43
 * @Package com.leikoooo.charpter1_link_test.level1
 * @Description
 */
public class DoublyLinkListTest {
    private DoubleNode first;
    private DoubleNode last;
    public DoublyLinkListTest() {
        first = null;
        last = first;
    }


    class DoubleNode {
        public int data;    //数据域
        public DoubleNode next;    //指向下一个结点
        public DoubleNode prev; // 前一个节点

        public DoubleNode(int data) {
            this.data = data;
        }

        //打印结点的数据域
        public void displayNode() {
            System.out.print("{" + data + "} ");
        }
    }

    /**
     * 从前向后遍历
     */
    public void displayForward() {
        System.out.print("List(first--->last): ");
        DoubleNode current = first;
        if (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 从后往前遍历
     */
    public void displayBackward() {
        System.out.println("list(last--->first):");
        DoubleNode current = last;
        while (current != null) {
            current.displayNode();
            current = current.prev;
        }
        System.out.println();
    }

    /**
     * 头节点插入
     */
    public void insertFirst(int data) {
        DoubleNode insertNode = new DoubleNode(data);
        if (isEmpty()) {
            last = insertNode;
        } else {
            first.prev = insertNode;
        }
        insertNode.next = first;
        first = insertNode;
    }

    public void insertLast(int data) {
        DoubleNode insertNode = new DoubleNode(data);
        if (isEmpty()) {
            // 这里把 first 设置为新的节点是为了保护双向链表的结构
            first = insertNode;
        } else {
            last.next = insertNode;
        }
        insertNode.prev = last;
        last = insertNode;
    }

    /**
     * 判断头节点是否为 null
     * @return
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * 某个结点的后部插入
     * @param key 要插入的位置的前面一个元素的值
     * @param data 需要填入的数据
     */
    public void insertAfter(int key, int data) {
        DoubleNode insertNode = new DoubleNode(data);
        DoubleNode current = first;
        if ((current != null) && (current.data != key)) {
            current = current.next;
        }
        // 找到了要插入的位置，在 current 的下一个节点
        if (current == null) {
            // 两种情况 1. 链表为空  2. 找不到数据
            if (isEmpty()) {
                first = insertNode;
                last = insertNode;
            } else {
                // 找不到数据，到最后面添加上
                insertNode.prev = last;
                last.next = insertNode;
                last = insertNode;
            }
        } else {
            // 可以找到对应的 key
            if (current == last) {
                insertNode.next = null;
                last = insertNode;
            } else {
                // 在中间插入
                insertNode.next = current.next;
                current.next.prev = insertNode;
            }
            current.next = insertNode;
            insertNode.prev = current;
        }




    }
    public static void main(String[] args) {
        DoublyLinkListTest doublyLinkListTest = new DoublyLinkListTest();
    }
}
