package com.epam.collections.interfaces;

import com.epam.collections.models.Student;

public interface DynamicArray {
    //appends the student to the end of the array
    void add(Student s);

    //removes the first occurrence of the specified student from the array if present.
    // Returns true, if succeed, and false otherwise
    boolean remove(Student s);

    //returns the number of elements in the array
    int size();

    //returns the student at index, and null otherwise
    Student get(int index) throws RuntimeException;
}
