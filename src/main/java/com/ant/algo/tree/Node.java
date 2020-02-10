package com.ant.algo.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by xile.su on 2020/1/20
 */
@Getter
@Setter
public class Node {
    private int data;

    private Node left;

    private Node right;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
