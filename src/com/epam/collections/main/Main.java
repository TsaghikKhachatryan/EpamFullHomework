package com.epam.collections.main;

import com.epam.collections.interfaces.DoublyLinkedList;
import com.epam.collections.interfaces.DynamicArray;
import com.epam.collections.models.Student;
import com.epam.collections.utils.StudentHelper;
import com.epam.collections.utils.StudentsDoublyLinkedList;
import com.epam.collections.utils.StudentsDynamicArray;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        manageStudents();
    }

    private static void manageStudents() {
        ArrayList<Student> studentsArrayList = StudentHelper.createStudentsArrayList();
        Student student = new Student("Abraham", "Poghosyan", 20);

        System.out.println("== Printing Students ordered by first name ascending and age descending order==");
        StudentHelper.sortByFirstNameAscendingAndAgeDescending(studentsArrayList);
        StudentHelper.printStudents(studentsArrayList);

        LinkedList<Student> studentsLinkedList = StudentHelper.createStudentsLinkedList();
        System.out.println("== Printing Students ordered by last  name ascending order ==");
        StudentHelper.sortByLastNameAscending(studentsLinkedList);
        StudentHelper.printStudents(studentsLinkedList);

        StudentsDynamicArray studentsDynamicArrayList = StudentHelper.createStudentsDynamicArrayList();
        System.out.println("== Printing Students First And LatNames in Dynamic array ==");
        StudentHelper.printStudentsFirstAndLatNames(studentsDynamicArrayList);
        studentsDynamicArrayList.remove(student);
        System.out.println("== Printing Students First And LatNames in Dynamic array after remove method ==");
        StudentHelper.printStudentsFirstAndLatNames(studentsDynamicArrayList);

        StudentsDoublyLinkedList studentsDoublyLinkedList = StudentHelper.createStudentsDoublyLinkedArray();
        System.out.println("== Printing Students First And LatNames in DoublyLinkedList ==");
        StudentHelper.printStudentsFirstAndLatNames(studentsDoublyLinkedList);
    }
}
