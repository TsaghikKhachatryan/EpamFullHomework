package com.epam.collections.utils;

import com.epam.collections.models.Student;

import java.util.*;

public class StudentHelper {

    public static ArrayList<Student> createStudentsArrayList() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Abraham", "Poghosyan", 20));
        students.add(new Student(2, "Abraham", "Serobyan", 55));
        students.add(new Student(3, "Barsegh", "Khachatryan", 19));
        students.add(new Student(4, "Barsegh", "Khachatryan", 50));
        students.add(new Student(5, "Colak", "Sisakyan", 21));
        students.add(new Student(6, "Martiros", "Nalbandyan", 25));
        return students;
    }

    public static LinkedList<Student> createStudentsLinkedList() {
        LinkedList<Student> students = new LinkedList<>();
        students.add(new Student(7, "Abraham", "Poghosyan", 20));
        students.add(new Student(8, "Barsegh", "Khachatryan", 19));
        students.add(new Student(9, "Colak", "Sisakyan", 21));
        students.add(new Student(10, "Martiros", "Nalbandyan", 25));
        return students;
    }

    public static StudentsDynamicArray createStudentsDynamicArrayList() {
        StudentsDynamicArray students = new StudentsDynamicArray();
        students.add(new Student(11, "Abraham", "Poghosyan", 20));
        students.add(new Student(12, "Barsegh", "Khachatryan", 19));
        students.add(new Student(13, "Colak", "Sisakyan", 21));
        students.add(new Student(14, "Martiros", "Nalbandyan", 25));
        return students;
    }

    public static StudentsDoublyLinkedList createStudentsDoublyLinkedArray() {
        StudentsDoublyLinkedList students = new StudentsDoublyLinkedList();
        students.addLast(new Student(15, "Abraham", "Poghosyan", 20));
        students.addLast(new Student(16, "Barsegh", "Khachatryan", 19));
        students.addLast(new Student(17, "Colak", "Sisakyan", 21));
        students.addLast(new Student(18, "Martiros", "Nalbandyan", 25));
        return students;
    }

    public static void sortByFirstNameAscendingAndAgeDescending(ArrayList<Student> students) {
        Collections.sort(students, new ComparatorStudentsByFirstNameAscendingAndAgeDescendingOrder());
    }

    public static void sortByLastNameAscending(LinkedList<Student> students) {
        Collections.sort(students);
    }

    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void printStudentsFirstAndLatNames(StudentsDynamicArray studentsDynamicArrayList) {
        for (int i = 0; i < studentsDynamicArrayList.size(); ++i) {
            Student student = studentsDynamicArrayList.get(i);
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
        System.out.println();
    }

    public static void printStudentsFirstAndLatNames(StudentsDoublyLinkedList studentsDoublyLinkedArray) {
        StudentsDoublyLinkedList.ListIterator iterator = studentsDoublyLinkedArray.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
        System.out.println();
    }
}