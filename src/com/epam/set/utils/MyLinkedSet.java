package com.epam.set.utils;

import com.epam.set.interfaces.Set;

/**
 * This class provides methods and properties for managing the current node instance,
 * and the binary tree in which
 * the left subtree of a node contains only nodes with keys lesser than the node’s key.
 * while the  right subtree of a node contains only nodes with keys greater than the node’s key.
 *
 * @author Tsaghik Khachatryan
 * @version 1.1
 * @since 2020-06-02
 */
public class MyLinkedSet<T extends Comparable> implements Set<T> {
    private Node root;
    private int size;

    public MyLinkedSet() {
        this.size = 0;
        this.root = new Node();
    }

    /**
     * @return the number of elements in this set
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Adds the specified element to this set
     * if it is not already present
     *
     * @param item - element to be added to this set
     * @return true if this set did not already contain the specified element
     * @throws NullPointerException - if the specified element is null
     */
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

    /**
     * Removes the specified element
     * from this set if it is present
     *
     * @param item - object to be removed from this set, if present
     * @return true if this set contained the specified element
     * @throws NullPointerException - if the specified element is null
     */
    @Override
    public boolean remove(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (contains(item)) {
            remove(root, item);
            --size;
            return true;
        }
        return false;
    }

    /**
     * Checks if set contains given item
     *
     * @param item- element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(T item) {
        return contains(root, item);
    }

    /**
     * Adds the specified element to this set
     *
     * @param node-contains a data
     * @param item-element  to be added to this set
     */
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

    /**
     * Removes the specified element from this set
     *
     * @param node-contains a data
     * @param item-element  to be added to this set
     */
    private Node remove(Node node, T item) {
        if (node == null || node.data == null) {
            return null;
        } else if (item.compareTo(node.data) < 0) {
            node.left = remove(node.left, item);
        } else if (item.compareTo(node.data) > 0) {
            node.right = remove(node.right, item);
        } else {
            if (node.left.data == null && node.right.data == null) {
                node = new Node();
            } else if (node.left.data == null) {
                node = node.right;
            } else if (node.right.data == null) {
                node = node.left;
            } else {
                Node temp = findMin(node.right);
                node.data = temp.data;
                node.right = remove(node.right, temp.data);
            }
        }
        return node;
    }

    /**
     * Traverse the node from root to
     * left recursively until left is NULL.
     * The node whose left is NULL is the node with minimum value.
     *
     * @param node-contains a data
     */
    private Node findMin(Node node) {
        Node current = node;
        while (current.left != null && current.left.data != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * To check if Set contains a given key
     *
     * @param node-contains a data
     * @param item-element  to be added to this set
     * @return true if the item is present at root,If item is greater
     * than root’s item, we recur for right subtree of root node.
     * Otherwise we recur for left subtree.
     * If Set is empty or doesn't contain item we return false.
     */
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

    /**
     * Traverses set and print it
     */
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

    /**
     * Node class contains data and also link to right and left nodes
     */
    private class Node {
        private T data;
        private Node left;
        private Node right;
    }
}
