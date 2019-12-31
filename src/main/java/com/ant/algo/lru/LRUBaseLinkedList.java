package com.ant.algo.lru;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xile.su on 2019/12/19
 */
public class LRUBaseLinkedList<T> {

    private int capacity;

    private int size;

    private Node<T> head;

    public LRUBaseLinkedList() {
        this(10);
    }

    public LRUBaseLinkedList(int capacity) {
        this.head = new Node();
        this.size = 0;
        this.capacity = capacity;
    }

    public void add(T element) {
        Node pre = getPreNode(element);
        if (pre != null) {
            Node node = pre.next;
            pre.next = node.next;
            node.next = head.next;
            head.next = node;
        } else {
            if (size == capacity) {
                deleteLast();
            }
            insertAtHead(element);
        }
    }

    private void insertAtHead(T element) {
        Node node = new Node(element, head.next);
        head.next = node;
        size++;
    }

    private void deleteLast() {
        Node node = head;
        if (node.next == null) {
            return;
        }
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        size--;
    }

    private Node getPreNode(T element) {
        Node node = this.head;
        while (node.next != null) {
            if (node.next.element.equals(element)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void printAll() {
        List<T> list = Lists.newArrayList();
        Node<T> node = head;
        while (node.next != null) {
            list.add(node.next.element);
            node = node.next;
        }
        System.out.println(list.toString());
    }


    public static class Node<T> {

        public Node() {
            this.next = null;
        }

        public Node(T element) {
            this.element = element;
            this.next = null;
        }

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        private T element;
        private Node<T> next;
    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            System.out.println(a);
            list.add(a);
            list.printAll();
        }
    }
}
