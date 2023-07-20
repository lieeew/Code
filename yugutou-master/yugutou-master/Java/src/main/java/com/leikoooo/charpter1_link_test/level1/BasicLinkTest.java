package com.leikoooo.charpter1_link_test.level1;

import com.yugutou.charpter1_linklist.level1.BasicLink;

/**
 * @author leikooo
 * @create 2023-07-16 19:48
 * @Package com.leikoooo.charpter1_link_test.level1
 * @Description
 */
public class BasicLinkTest {

    public static void main(String[] args) {
        Node node = initLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(node);
    }

    /**
     * 创建一串 Node
     */
    public static Node initLinkedList(int[] array) {
        // 定义一个头部节点和当前节点
        // 这个头节点的作用是用于找到该链表，作用通过头节点可以找到整个链表的其他节点
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

    static class Node {
        int data;

        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
