package com.ant.algo.tree;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by xile.su on 2020/1/20
 */
public class TreeUtil {

    /**
     * 深度优先思想的递归，分别求左右子树的高度。当前节点的高度就是左右子树中较大的那个+1
     */
    public static int getHeight1(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        }

        int leftHeight = getHeight1(node.getLeft());
        int rightHeight = getHeight1(node.getRight());
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 按层遍历
     */
    public static int getHeight2(Node node) {
        if (node == null) {
            return 0;
        }
        int level = 1;
        List<Node> curLevel = Lists.newArrayList(node);
        while (true) {
            List<Node> nextLevel = getNextLevel(curLevel);
            if (nextLevel.isEmpty()) {
                break;
            } else {
                level++;
                curLevel = nextLevel;
            }
        }
        return level - 1;
    }

    public static List<Node> getNextLevel(List<Node> curLevel) {
        List<Node> nodes = Lists.newArrayList();
        for (Node node : curLevel) {
            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
//        //   1
//        //  / \
//        // 2   3
//        //      \
//        //       4
//        //      /
//        //     5
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        node1.setLeft(node2);
//        node1.setRight(node3);
//        node3.setRight(node4);
//        node4.setLeft(node5);
//
//        System.out.println(getHeight1(node1));
//        System.out.println(getHeight2(node1));
//
//        System.out.println(getHeight1(node2));
//        System.out.println(getHeight2(node2));
//
//        System.out.println(getHeight1(node3));
//        System.out.println(getHeight2(node3));
//
//        System.out.println(getHeight1(node4));
//        System.out.println(getHeight2(node4));
//
//        System.out.println(getHeight1(node5));
//        System.out.println(getHeight2(node5));
        printCompleteTree(null, 1, 100);
    }

    /**
     * 打印完全二叉树
     */
    public static void printCompleteTree(int[] arr, int from, int to) {
        // 每一层的数组下标
        List<List<Integer>> levels = getLevels(from, to);
        int maxLevel = levels.size();
        for (int i = 0; i < levels.size(); i++) {
            int curLevel = 1;
            printBlank((maxLevel - curLevel) * 2);
            System.out.println("第" + (i + 1) + "层: " + levels.get(i));
        }
    }

    private static void printBlank(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public static List<List<Integer>> getLevels(int from, int to) {
        List<List<Integer>> levels = Lists.newArrayList();
        levels.add(Lists.newArrayList(from));
        while (true) {
            List<Integer> preLevel = levels.get(levels.size() - 1);
            List<Integer> curLevel = Lists.newArrayList();
            for (int i : preLevel) {
                if (2 * i <= to) {
                    curLevel.add(2 * i);
                } else {
                    break;
                }

                if (2 * i + 1 <= to) {
                    curLevel.add(2 * i + 1);
                } else {
                    break;
                }
            }
            if (!curLevel.isEmpty()) {
                levels.add(curLevel);
            }
            // 完全二叉树除最后一层以外其他层的节点数量都是上一层的两倍
            if (curLevel.size() != preLevel.size() * 2) {
                break;
            }
        }
        return levels;
    }
}
