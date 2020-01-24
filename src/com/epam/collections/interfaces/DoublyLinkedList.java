package com.epam.collections.interfaces;

import com.epam.collections.models.Student;

public interface DoublyLinkedList {
    //inserts the student at the front of the list
    void push(Student student);

    //removes and returns the first student of the list
    Student pop() throws NullPointerException;

    //appends the specified student to the end of the list
    void addLast(Student student);

    //removes and returns the last student
    Student removeLast() throws NullPointerException;

    //returns the number of students in this list
    int size();
}

