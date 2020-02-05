package com.epam.set.utils;

import com.epam.set.interfaces.Set;

public class MyLinkedSet<T extends Comparable> implements Set<T> {
    private Node root;
    private int size;

    public MyLinkedSet() {
        this.size = 0;
        this.root = new Node();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean add(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (contains(item)) {
            return false;
        } else {
            add(root, item);
            ++size;
            return true;
        }
    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public boolean contains(T item) {
        return contains(root, item);
    }

    private void add(Node node, T item) {
        if (node.data == null) {
            node.data = item;
            node.left = new Node();
            node.right = new Node();
        } else if (item.compareTo(node.data) < 0) {
            add(node.left, item);
        } else {
            add(node.right, item);
        }
    }

    private boolean contains(Node node, T item) {
        if (node == null || node.data == null) {
            return false;
        }
        if (item.equals(node.data)) {
            return true;
        }
        boolean resultLeft = contains(node.left, item);
        boolean resultRight = contains(node.right, item);
        return resultLeft || resultRight;
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node.data != null) {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    private class Node {
        private T data;
        private Node left;
        private Node right;
    }
}
