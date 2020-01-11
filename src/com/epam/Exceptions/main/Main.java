package com.epam.Exceptions.main;

import com.epam.Exceptions.FacultyAbsenceException;
import com.epam.Exceptions.helpers.UniversityHelper;
import com.epam.Exceptions.models.*;

public class Main {
    public static void main(String[] args) {
        University university = UniversityHelper.creteTheUniversity();

        //Getting random student from University and calculating average mark
        UniversityHelper.calculateStudentsAverageMarkFromAllSubjects(UniversityHelper.getRandomStudent(university));

        //Getting a random group from University and calculating average mark from random subject of that group
        Group group = UniversityHelper.getRandomGroup(university);
        UniversityHelper.calculateAverageMarkOfGroupFromSubject(group, UniversityHelper.getRandomSubject(group));

        //Getting a random faculty from University and calculating average mark from random subject of that faculty
        Faculty faculty = UniversityHelper.getRandomFaculty(university);
        UniversityHelper.calculateAverageMarkOfFacultyFromSubject(faculty, UniversityHelper.getRandomSubject(faculty));

        try {
            UniversityHelper.calculateAverageMarkOfUniversityFromSubject(university,
                    UniversityHelper.getRandomSubject(university));
        } catch (FacultyAbsenceException e) {
            System.out.println(e.toString());
        }
    }
}