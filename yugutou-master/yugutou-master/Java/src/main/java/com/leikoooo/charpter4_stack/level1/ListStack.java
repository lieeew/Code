package com.leikoooo.charpter4_stack.level1;

/**
 * @author leikooo
 */
class ListStack<T> {
    //定义链表
    class Node<T> {
        public T t;
        public Node next;
    }

    public Node<T> head;

    //构造函数初始化头指针
    ListStack() {
        head = null;
    }

    /**
     * 是否为 null
     *
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * 取出头节点元素
     */
    public T peek() {
        return (T) head.t;
    }

    /**
     * 入栈
     */
    public void push(T t) {
        // 初始化需要插入的 节点
        Node<T> tNode = new Node<T>();
        tNode.t = t;
        // 直接替换头节点
        tNode.next = head;
        head = tNode;
    }

    /**
     * 出栈
     * @return
     */
    public T pop () {
        T peek = peek();
        if (head.next == null) {
            head = null;
        }
        head = head.next;
        return peek;
    }

    public static void main(String[] args) {
        ListStack stack = new ListStack();
        System.out.println(stack.isEmpty());
        stack.push("Java");
        stack.push("is");
        stack.push("beautiful");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}