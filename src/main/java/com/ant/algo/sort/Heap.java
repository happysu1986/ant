package com.ant.algo.sort;

import java.util.Random;

/**
 * Created by xile.su on 2020/1/30
 */
public class Heap {
    private int[] elements;

    // 最后一个元素的下标，从 1 开始
    private int tail;

    public Heap() {
        this.tail = 0;
        elements = new int[10];
    }

    public void insert(int element) {
        if (tail == elements.length - 1) {
            extend();
        }
        int index = tail + 1;
        elements[index] = element;
        while (index > 1 && elements[index] > elements[index / 2]) {
            swap(index, index / 2);
            index = index / 2;
        }
        tail++;
    }

    public void remove(int index) {
        if (index < 1 || index > tail) {
            return;
        }
        System.out.println("remove index: " + index + ", value: " + elements[index]);

        if (index == tail) {
            tail--;
            return;
        }

        int last = elements[tail--];
        elements[index] = last;
        while (true) {
            int maxIndex = index;
            // 比较左子节点
            if (index * 2 <= tail) {
                if (elements[index * 2] > elements[maxIndex]) {
                    maxIndex = index * 2;
                }
            }

            // 比较右子节点
            if (index * 2 + 1 <= tail) {
                if (elements[index * 2 + 1] > elements[maxIndex]) {
                    maxIndex = index * 2 + 1;
                }
            }

            if (maxIndex == index) {
                break;
            }
            swap(index, maxIndex);
            index = maxIndex;
        }
    }

    private void extend() {
        int[] tmp = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
    }

    private void swap(int i, int k) {
        int tmp = elements[i];
        elements[i] = elements[k];
        elements[k] = tmp;
    }

    public void print() {
        if (tail == 0) {
            System.out.println("[]");
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 1; i <= tail; i++) {
            sb.append(elements[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Random random = new Random();
        Heap heap = new Heap();
        for (int i = 0; i < 20; i++) {
            heap.insert(random.nextInt(100));
        }
        System.out.println("init");
        heap.print();

        System.out.println("remove 3");
        heap.remove(3);
        heap.print();
    }
}
