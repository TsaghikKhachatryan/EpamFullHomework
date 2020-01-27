package com.epam.collections.utils;

import com.epam.collections.interfaces.DynamicArray;
import com.epam.collections.models.Student;

import java.util.Arrays;

public class StudentsDynamicArray implements DynamicArray {
    private final int DEFAULT_SIZE = 10;
    private final int EXPANSION_COEFFICIENT = 2;
    private int index = 0;
    private Student[] students;

    public StudentsDynamicArray() {
        students = new Student[DEFAULT_SIZE];
    }

    @Override
    public void add(Student student) {
        if (index == students.length) {
            students = Arrays.copyOf(students, students.length * EXPANSION_COEFFICIENT);
        }
        students[index++] = student;
    }

    @Override
    public boolean remove(Student student) {
        boolean found = false;
        for (int j = 0, i = 0; i < size(); ++i) {
            if (students[i].equals(student) && !found) {
                found = true;
            }
            if (found) {
                if (i == size() - 1) {
                    students[i] = null;
                    --index;
                } else {
                    students[i] = students[i + 1];
                }
            }
        }
        return found;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Student get(int index) {
        if (0 <= index && index < students.length) {
            return students[index];
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }
}