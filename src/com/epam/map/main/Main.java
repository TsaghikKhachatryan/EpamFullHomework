package com.epam.map.main;

import com.epam.map.models.Student;
import com.epam.map.utils.StudentMapHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        manageStudents();
    }

    private static void manageStudents() {
        StudentMapHelper studentMapHelper = new StudentMapHelper();
        ArrayList<Student> studentArrayList = studentMapHelper.initStudentsArrayList();
        HashMap<Student, Integer> studentsHashMap = studentMapHelper.fillHashMapFromArrayList(studentArrayList);
        studentMapHelper.printHashMap(studentsHashMap);
    }
}
