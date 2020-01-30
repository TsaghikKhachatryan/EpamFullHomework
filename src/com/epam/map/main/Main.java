package com.epam.map.main;

import com.epam.map.models.Faculties;
import com.epam.map.models.Student;
import com.epam.map.utils.StudentMapHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        manageStudents();
    }

    private static void manageStudents() {
        System.out.println("task 1");
        ArrayList<Student> studentArrayList = StudentMapHelper.createStudentsArrayList();
        HashMap<Student, Integer> studentsHashMap = StudentMapHelper.createHashMapFromArrayList(studentArrayList);
        StudentMapHelper.printStudentsHashMap(studentsHashMap);
        System.out.println("task 2");
        HashMap<Faculties, Integer> facultyHashMap = StudentMapHelper.calculateStudentsCountInFaculty(studentArrayList);
        StudentMapHelper.printStudentsCountInEachFaculty(facultyHashMap);
    }
}