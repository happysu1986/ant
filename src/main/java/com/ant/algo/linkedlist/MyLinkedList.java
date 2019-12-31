package com.ant.algo.linkedlist;

import lombok.Data;

/**
 * Created by xile.su on 2019/12/20
 */
public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {
    }

    public void addAtHead(T element) {
        Node<T> newNode = new Node(element, head);
        if (tail == null) {
            tail = newNode;
        }
        head = newNode;
    }

    public void addAtTail(T element) {
        Node<T> newNode = new Node(element, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void add(T element) {
        addAtTail(element);
    }

    public void printAll() {
        Node node = head;
        StringBuffer sb = new StringBuffer();

        sb.append("[");
        while (node != null) {
            sb.append(node.element.toString())
              .append(",");
            node = node.next;
        }
        if (head != null) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");

        System.out.println(sb.toString());
    }

    /**
     * 反转队列
     */
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

            head = pre;
        }
    }

    /**
     * 检测链表中是否有环
     * 以下链表包含环：
     * <pre>
     * 1 -> 2 -> 3 -> 4 ->5 ---
     *           ^            |
     *           |-------------
     * <pre/>
     */
    public boolean haveCircle() {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除倒数第 N 个节点
     */
    public void deleteLastN(int n) {
        if (n <= 0) {
            return;
        }
        if (head == null) {
            return;
        }
        Node pre = head;
        Node fast = head;
        int i = 0;
        for (; i < n && fast != null; i++) {
            fast = fast.next;
        }
        if (i != n) {
            return;
        }

        if (fast == null) {
            head = head.next;
            return;
        }
        while (fast.next != null) {
            pre = pre.next;
            fast = fast.next;
        }
        pre.next = pre.next.next;
    }

    public Node getMiddel() {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Data
    public static class Node<T> {

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        private T element;
        private Node<T> next;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.printAll();
        list.reverse();
        list.printAll();

        list.deleteLastN(1);
        list.printAll();
    }
}
