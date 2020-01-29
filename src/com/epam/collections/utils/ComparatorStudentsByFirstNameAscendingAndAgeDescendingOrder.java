package com.epam.collections.utils;

import com.epam.collections.models.Student;

import java.util.Comparator;

public class ComparatorStudentsByFirstNameAscendingAndAgeDescendingOrder implements Comparator<Student>{

    @Override
    public int compare(Student student1, Student studnt2) {
        int result = student1.getFirstName().compareTo(studnt2.getFirstName());
        if (result == 0) {
            result = -(student1.getAge() - studnt2.getAge());
        }
        return result;
    }
}

