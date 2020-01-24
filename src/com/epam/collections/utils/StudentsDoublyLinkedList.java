package com.epam.collections.utils;

import com.epam.collections.interfaces.DoublyLinkedList;
import com.epam.collections.models.Student;

import java.util.Iterator;

public class StudentsDoublyLinkedList implements DoublyLinkedList, Iterable {
    private int size = 0;
    private StudentNode headNode;
    private StudentNode lastNode;

    public StudentNode getHeadNode() {
        return headNode;
    }

    public ListIterator iterator() {
        return new ListIterator(this);
    }

    @Override
    public void push(Student student) {
        StudentNode node = new StudentNode(student);
        if (headNode == null) {
            lastNode = node;
        } else {
            node.setNext(headNode);
            headNode.setPrevious(node);
        }
        headNode = node;
        ++size;
    }

    @Override
    public Student pop() {
        if (headNode == null) {
            throw new NullPointerException("Students doubly linked list is empty");
        } else {
            StudentNode removingNode = headNode;
            if (headNode.getNext() == null) {
                lastNode = null;
            } else {
                headNode.getNext().setPrevious(null);
            }

            headNode = headNode.getNext();
            removingNode.setNext(null);
            --size;
            return removingNode.getStudent();
        }
    }

    @Override
    public void addLast(Student student) {
        StudentNode node = new StudentNode(student);
        if (lastNode == null) {
            headNode = node;
        } else {
            lastNode.setNext(node);
            node.setPrevious(lastNode);
        }
        lastNode = node;
        ++size;
    }

    @Override
    public Student removeLast() {
        if (lastNode == null) {
            throw new NullPointerException("Students doubly linked list is empty");
        } else {
            StudentNode removingNode = lastNode;
            if (lastNode.getPrevious() == null) {
                headNode = null;
            } else {
                lastNode.getPrevious().setNext(null);
            }

            lastNode = lastNode.getPrevious();
            removingNode.setPrevious(null);
            --size;
            return removingNode.getStudent();
        }
    }

    @Override
    public int size() {
        return size;
    }

    private static class StudentNode {
        private Student student;
        private StudentNode next;
        private StudentNode previous;

        public StudentNode(Student student) {
            this.student = student;
        }

        public Student getStudent() {
            return student;
        }

        public StudentNode getNext() {
            return next;
        }

        public void setNext(StudentNode next) {
            this.next = next;
        }

        public StudentNode getPrevious() {
            return previous;
        }

        public void setPrevious(StudentNode previous) {
            this.previous = previous;
        }
    }

    public class ListIterator implements Iterator {
        StudentNode current;

        public ListIterator(StudentsDoublyLinkedList doublyLinkedList) {
            current = doublyLinkedList.getHeadNode();
        }

        public boolean hasNext() {
            return current != null;
        }

        public Student next() {
            Student student = current.getStudent();
            current = current.getNext();
            return student;
        }
    }
}