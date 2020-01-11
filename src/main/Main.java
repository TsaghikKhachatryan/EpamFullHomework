package main;

import Exceptions.FacultyAbsenceException;
import helpers.UniversityHelper;
import models.*;

public class Main {
    public static void main(String[] args) {
        UniversityHelper universityHelper = new UniversityHelper();
        universityHelper.creteTheUniversity();
        Faculty faculty = UniversityHelper.university.getFaculties()[0];
        Group group = faculty.getGroups()[0];
        Student student = group.getStudents()[1];

        try {
            UniversityHelper.calculateAverageMarkOfUniversityFromSubject(UniversityHelper.university, student.getSubjects()[0]);
        } catch (FacultyAbsenceException e) {
            System.out.println(e.toString());
        }
    }

}
