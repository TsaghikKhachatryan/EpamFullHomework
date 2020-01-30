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
        ArrayList<Student> studentArrayList = StudentMapHelper.createStudentsArrayList();
        HashMap<Student, Integer> studentsHashMap = StudentMapHelper.createHashMapFromArrayList(studentArrayList);
        StudentMapHelper.printStudentsHashMap(studentsHashMap);
        StudentMapHelper.printFaculties();

    }
}