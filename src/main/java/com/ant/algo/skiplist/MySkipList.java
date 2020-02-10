package com.ant.algo.skiplist;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xile.su on 2020/1/13
 */
public class MySkipList {

    private static final int MAX_LEVEL = 16;

    private int levelCount = 0;

    private Node head = new Node();

    public Node find(int value) {
        Node p = head;
        // 定位 value 的前序节点
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }
        }

        if (p.next[0] != null && p.next[0].data == value) {
            return p.next[0];
        } else {
            return null;
        }

    }

    public void insert(int value) {
        int level = randomLevel();
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }
            update[i] = p;
        }

        Node newNode = new Node();
        newNode.data = value;
        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
        if (levelCount < level) {
            levelCount = level;
        }
    }

    public void insert2(int value) {
        int level = head.next[0] == null ? 1 : randomLevel();
        // 每次只增加一层，如果条件满足
        if (level > levelCount) {
            level = ++levelCount;
        }
        Node newNode = new Node();
        newNode.data = value;
        Node p = head;
        // 从最大层开始查找，找到前一节点，通过--i，移动到下层再开始查找
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.next[i] != null && p.next[i].data < value) {
                // 找到前一节点
                p = p.next[i];
            }
            // levelCount 会 > level，所以加上判断
            if (level > i) {
                if (p.next[i] == null) {
                    p.next[i] = newNode;
                } else {
                    Node next = p.next[i];
                    p.next[i] = newNode;
                    newNode.next[i] = next;
                }
            }

        }

    }

    public void printAll() {
        List<Integer> list = Lists.newArrayList();
        Node p = head;
        while (p.next[0] != null) {
            p = p.next[0];
            list.add(p.data);
        }
        System.out.println(list.toString());
    }

    // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
    // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
    //        50%的概率返回 1
    //        25%的概率返回 2
    //      12.5%的概率返回 3 ...
    private int randomLevel() {
        int level = 1;

        while (Math.random() < 0.5 && level < MAX_LEVEL) {
            level += 1;
        }
        return level;
    }


    private static class Node {
        private Integer data;
        // 记录每一层的 next 节点
        private Node[] next = new Node[MAX_LEVEL];

//        @Override
//        public String toString() {
//
//        }
    }

    public static void main(String[] args) {
        MySkipList skipList = new MySkipList();
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

        Node node = skipList.find(11);

        System.out.println("find 10: " + (skipList.find(10) != null));
        System.out.println("find 11: " + (skipList.find(11) != null));
        System.out.println("find -1: " + (skipList.find(-1) != null));

        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        HashMap<Integer,Integer> m = new LinkedHashMap(10, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);
        m.put(3, 26);
        m.get(5);
        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
    }
}
