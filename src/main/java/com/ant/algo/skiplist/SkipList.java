package com.ant.algo.skiplist;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 跳表的一种实现方法。
 * 跳表中存储的是正整数，并且存储的是不重复的。
 *
 * Author：ZHENG
 */
public class SkipList {

    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node();  // 带头链表

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node update[] = new Node[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // record every level largest value which smaller than insert value in update[]
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;// use update save node in search path
        }

        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // update node hight
        if (levelCount < level) {
            levelCount = level;
        }
//
//        System.out.println("value: " + value + ", level: " + level);
//        printByLevel();
//        printAll2();
//        System.out.println("-------------------------------");
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

        while (levelCount > 1 && head.forwards[levelCount] == null) {
            levelCount--;
        }

    }

    // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
    // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
    //        50%的概率返回 1
    //        25%的概率返回 2
    //      12.5%的概率返回 3 ...
    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
            level += 1;
        }
        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();

    }

    public void printAll2() {
        List<Integer> list = Lists.newArrayList();
        Node p = head;
        while (p.forwards[0] != null) {
            p = p.forwards[0];
            list.add(p.data);
        }
        System.out.println("list: " + list);

    }

    public void printByLevel() {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Node p = head;
        while (p.forwards[0] != null) {
            p = p.forwards[0];
            int level = p.maxLevel;
            List<Integer> nodes = map.get(level);
            if (nodes == null) {
                nodes = Lists.newArrayList();
                map.put(level, nodes);
            }
            nodes.add(p.data);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println("level: " + entry.getKey() + ", values: " + entry.getValue());
        }
    }

    public class Node {

        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(3);
        skipList.insert(5);
        skipList.insert(2);
        skipList.insert(6);
        skipList.insert(9);
        skipList.insert(8);
        skipList.insert(7);
        skipList.insert(4);
        skipList.insert(0);
        skipList.insert(10);
        skipList.insert(19);
        skipList.insert(12);
        skipList.insert(13);
        skipList.insert(15);
        skipList.insert(18);
        skipList.insert(17);

        skipList.printAll();

        Node node = skipList.find(10);
        System.out.println("find 10: " + node != null);
        System.out.println("find 11: " + skipList.find(11) != null);
        System.out.println("find -1: " + skipList.find(-1) != null);
    }

}
