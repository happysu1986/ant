package com.ant.algo.tree;

/**
 * Created by xile.su on 2020/1/21
 */
public class MyBinarySearchTree {

    private Node tree;

    public void insert(int data) {
        Node node = new Node(data);
        if (tree == null) {
            tree = node;
            return;
        }

        Node p = tree;
        while (p != null) {
            if (p.getData() > data) {
                if (p.getLeft() == null) {
                    p.setLeft(node);
                    return;
                }
                p = p.getLeft();
            } else {
                if (p.getRight() == null) {
                    p.setRight(node);
                    return;
                }
                p = p.getRight();
            }
        }
    }
}
