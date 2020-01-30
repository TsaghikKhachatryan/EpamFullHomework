package com.epam.map.utils;

import com.epam.map.models.Faculty;
import com.epam.map.models.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentMapHelper {
    private ArrayList<Student> studentsArrayList = new ArrayList<>();
    private HashMap<Student, Integer> studentsHashMap = new HashMap<>();

    public ArrayList<Student> initStudentsArrayList() {
        studentsArrayList.add(new Student("Hayk", "Sargsyan", "+374098546327", Faculty.PHYSICS, 20));
        studentsArrayList.add(new Student("Hayk", "Sargsyan", "+374098546327", Faculty.SOCIOLOGY, 26));
        studentsArrayList.add(new Student("Hayk", "Sargsyan", "+374098546327", Faculty.ENGLISH, 27));
        studentsArrayList.add(new Student("Hayk", "Sargsyan", "+374098512555", Faculty.MATH, 17));
        studentsArrayList.add(new Student("Ani", "Sargsyan", "+374098546327", Faculty.PHILOSOPHY, 25));
        studentsArrayList.add(new Student("Ani", "Sargsyan", "+374098546327", Faculty.ENGLISH, 15));
        studentsArrayList.add(new Student("Anna", "Sargsyan", "+374098546327", Faculty.PHYSICS, 18));
        studentsArrayList.add(new Student("Anna", "Sargsyan", "+374098546327", Faculty.MATH, 19));
        return studentsArrayList;
    }

    public HashMap<Student, Integer> fillHashMapFromArrayList(ArrayList<Student> studentsArrayList) {
        for (Student student : studentsArrayList) {
            if (studentsHashMap.get(student) == null) {
                studentsHashMap.put(student, 1);
            } else {
                studentsHashMap.put(student, studentsHashMap.get(student) + 1);
            }
        }
        return studentsHashMap;
    }

    public void printHashMap(HashMap<Student, Integer> studentsHashMap) {
        for (Student student : studentsHashMap.keySet()) {
            String key = student.toString();
            String value = studentsHashMap.get(student).toString();
            System.out.println(key + " " + value);
        }
    }


}
