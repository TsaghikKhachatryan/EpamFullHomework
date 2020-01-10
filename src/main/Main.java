package main;

import helpers.UniversityHelper;
import models.*;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        UniversityHelper universityHelper = new UniversityHelper();
        universityHelper.creteTheUniversity();
        Faculty faculty = UniversityHelper.university.getFaculties()[0];
        Group group = faculty.getGroups()[0];
        Student student = group.getStudents()[1];
        UniversityHelper.calculateStudentsAverageMarkOfGroupFromSubject(group,student.getSubjects()[0]);
        float f = universityHelper.calculateStudentsAverageMarkOfFacultetFromSubject(faculty,student.getSubjects()[0]);
        System.out.println(f);
    }

}
