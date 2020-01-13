package com.epam.main;

import com.epam.helpers.UniversityHelper;
import com.epam.models.*;

public class Main {
    public static void main(String[] args) {
        University university = UniversityHelper.creteTheUniversity();

        //Getting random student from University and calculating average mark
        UniversityHelper.getStudentsAverageMarkFromAllSubjects(UniversityHelper.getRandomStudent(university));

        //Getting a random group from University and calculating average mark from random subject of that group
        Group group = UniversityHelper.getRandomGroup(university);
        UniversityHelper.getAverageMarkOfGroupFromSubject(group, UniversityHelper.getRandomSubject());

        //Getting a random faculty from University and calculating average mark from random subject of that faculty
        Faculty faculty = UniversityHelper.getRandomFaculty(university);
        UniversityHelper.getAverageMarkOfFacultyFromSubject(faculty, UniversityHelper.getRandomSubject());

        UniversityHelper.getAverageMarkOfUniversityFromSubject(university, UniversityHelper.getRandomSubject());
    }
}