package com.epam.collections.utils;

import com.epam.collections.models.Student;

import java.util.Comparator;

public class ComparatorByStudentsAgeDescending implements Comparator {

    @Override
    public int compare(Object object1, Object object2) {
        int result = ((Student) object1).getAge() - (((Student) object2).getAge());
        if (result == 0) {
            result = ((Student) object1).getFirstName().compareTo(((Student) object2).getFirstName());
        }
        if (result == 0) {
            result = ((Student) object1).getLastName().compareTo(((Student) object2).getLastName());
        }
        return result;
    }
}