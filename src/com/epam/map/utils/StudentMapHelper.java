package com.epam.map.utils;

import com.epam.map.models.Faculties;
import com.epam.map.models.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StudentMapHelper {

    public static ArrayList<Student> createStudentsArrayList() {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        studentsArrayList.add(new Student("Hayk", "Sargsyan", "+3740980101010", Faculties.PHYSICS, 20));
        studentsArrayList.add(new Student("Hayk", "Sargsyan", "+374098000000", Faculties.SOCIOLOGY, 26));
        studentsArrayList.add(new Student("Hayk", "Sargsyan", "+374094446327", Faculties.ENGLISH, 27));
        studentsArrayList.add(new Student("Hayk", "Sargsyan", "+374098512555", Faculties.MATH, 17));
        studentsArrayList.add(new Student("Ani", "Sargsyan", "+374098546327", Faculties.MATH, 25));
        studentsArrayList.add(new Student("Ani", "Sargsyan", "+374098010202", Faculties.ENGLISH, 15));
        studentsArrayList.add(new Student("Anna", "Sargsyan", "+374098546327", Faculties.PHYSICS, 18));
        studentsArrayList.add(new Student("Anna", "Sargsyan", "+374098546327", Faculties.MATH, 19));
        return studentsArrayList;
    }

    public static HashMap<Student, Integer> createHashMapFromArrayList(ArrayList<Student> studentsArrayList) {
        HashMap<Student, Integer> studentsHashMap = new HashMap<>();
        for (Student student : studentsArrayList) {
            if (studentsHashMap.get(student) == null) {
                studentsHashMap.put(student, 1);
            } else {
                studentsHashMap.put(student, studentsHashMap.get(student) + 1);
            }
        }
        return studentsHashMap;
    }

    public static HashMap<Faculties, Integer> calculateStudentsCountInFaculty(ArrayList<Student> studentsArrayList) {
        HashMap<Faculties, Integer> facultiesHashMap = new HashMap<>();
        for (Faculties faculty : Faculties.values()) {
            facultiesHashMap.put(faculty, 0);
        }
        for (Student student : studentsArrayList) {
            Faculties faculty = student.getFaculty();
            facultiesHashMap.put(faculty, facultiesHashMap.get(faculty) + 1);
        }
        return facultiesHashMap;
    }

    public static void printStudentsCountInEachFaculty(HashMap<Faculties, Integer> facultiesHashMap) {
        for (Faculties faculties : facultiesHashMap.keySet()) {
            Integer value = facultiesHashMap.get(faculties);
            System.out.println(faculties + " " + value);
        }
    }

    public static void printStudentsHashMap(HashMap<Student, Integer> studentsHashMap) {
        System.out.println(studentsHashMap.entrySet());
    }
}
