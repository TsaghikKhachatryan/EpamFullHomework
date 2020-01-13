package com.epam.helpers;

import com.epam.exceptions.FacultyAbsenceException;
import com.epam.exceptions.GroupAbsenceException;
import com.epam.exceptions.StudentAbsenceException;
import com.epam.exceptions.SubjectAbsenceException;
import com.epam.models.*;

import java.util.Random;

public class UniversityHelper {

    private static final String MATHEMATICS = "Mathematics";
    private static final String ARMENIAN = "ARMENIAN";
    private static final String LOGIC = "LOGIC";
    private static final String SOCIOLOGY = "SOCIOLOGY";
    private static final String PHYSICS = "PHYSICS";
    private static final String ENGLISH = "ENGLISH";

    private static final String[] ALL_SUBJECTS = new String[]{MATHEMATICS, ARMENIAN, LOGIC, SOCIOLOGY, PHYSICS, ENGLISH};

    public static University creteTheUniversity() {

        Mark.MarkBuilder markBuilder = new Mark.MarkBuilder();
        Mark physicsA = markBuilder.subject(PHYSICS).value(5).build();
        Mark physicsB = markBuilder.subject(PHYSICS).value(4).build();
        Mark physicsC = markBuilder.subject(PHYSICS).value(3).build();

        Mark sociologyA = markBuilder.subject(SOCIOLOGY).value(5).build();
        Mark sociologyB = markBuilder.subject(SOCIOLOGY).value(4).build();
        Mark sociologyC = markBuilder.subject(SOCIOLOGY).value(3).build();

        Mark armenianA = markBuilder.subject(ARMENIAN).value(5).build();
        Mark armenianB = markBuilder.subject(ARMENIAN).value(4).build();
        Mark armenianC = markBuilder.subject(ARMENIAN).value(3).build();

        Mark mathematicsA = markBuilder.subject(MATHEMATICS).value(5).build();
        Mark mathematicsB = markBuilder.subject(MATHEMATICS).value(4).build();
        Mark mathematicsC = markBuilder.subject(MATHEMATICS).value(3).build();

        Mark logicA = markBuilder.subject(LOGIC).value(5).build();
        Mark logicB = markBuilder.subject(LOGIC).value(4).build();
        Mark logicC = markBuilder.subject(LOGIC).value(3).build();

        Mark englishA = markBuilder.subject(ENGLISH).value(5).build();
        Mark englishB = markBuilder.subject(ENGLISH).value(4).build();
        Mark englishC = markBuilder.subject(ENGLISH).value(3).build();

        Student.StudentBuilder studentBuilder = new Student.StudentBuilder();
        Student student1 = studentBuilder
                .firstName("Ani")
                .lastName("Poghosyan")
                .subject(new String[]{PHYSICS, SOCIOLOGY, ARMENIAN, LOGIC})
                .marks(new Mark[]{physicsB, sociologyC, armenianA})
                .build();

        Student student2 = studentBuilder
                .firstName("Aram")
                .lastName("Nikoyan")
                .subject(new String[]{MATHEMATICS, LOGIC, SOCIOLOGY})
                .marks(new Mark[]{physicsC, sociologyC, armenianB, armenianB, physicsB})
                .build();

        Student student3 = studentBuilder
                .firstName("Lilit")
                .lastName("Azizyan")
                .subject(new String[]{ENGLISH, LOGIC, ARMENIAN})
                .marks(new Mark[]{physicsA, sociologyA, armenianB, physicsA, sociologyB})
                .build();

        Student student4 = studentBuilder
                .firstName("Anna")
                .lastName("Poghosyan")
                .subject(new String[]{SOCIOLOGY, ENGLISH, PHYSICS, LOGIC})
                .marks(new Mark[]{mathematicsA, logicC, sociologyA, logicB})
                .build();

        Student student5 = studentBuilder
                .firstName("Arman")
                .lastName("Nikoyan")
                .subject(new String[]{PHYSICS, SOCIOLOGY, ARMENIAN})
                .marks(new Mark[]{mathematicsA, logicA, sociologyB, mathematicsB, mathematicsC})
                .build();

        Student student6 = studentBuilder
                .firstName("Karine")
                .lastName("Poghosyan")
                .subject(new String[]{MATHEMATICS, LOGIC, SOCIOLOGY, ARMENIAN})
                .marks(new Mark[]{logicC, armenianA, logicB, englishB})
                .build();

        Student student7 = studentBuilder
                .firstName("Minas")
                .lastName("Nikoyan")
                .subject(new String[]{ENGLISH, LOGIC, ARMENIAN, LOGIC})
                .marks(new Mark[]{logicA, armenianA, logicB, englishC, armenianA, armenianC})
                .build();

        Student student8 = studentBuilder
                .firstName("Marine")
                .lastName("Khachatryan")
                .subject(new String[]{SOCIOLOGY, ENGLISH, PHYSICS})
                .marks(new Mark[]{sociologyA, sociologyA, englishB, physicsB})
                .build();

        Student student9 = studentBuilder
                .firstName("Davit")
                .lastName("Grigoryan")
                .subject(new String[]{PHYSICS, SOCIOLOGY, ARMENIAN, ENGLISH})
                .marks(new Mark[]{physicsA, englishC, sociologyA, englishA, armenianB})
                .build();

        Group group1 = new Group("701", new Student[]{student1, student2, student3});
        Group group2 = new Group("702", new Student[]{student4, student5});
        Group group3 = new Group("501", new Student[]{student6, student7});
        Group group4 = new Group("502", new Student[]{student8, student9});

        Faculty faculty1 = new Faculty("Applied Mathematics", new Group[]{group1, group2});
        Faculty faculty2 = new Faculty("romanGermanic", new Group[]{group3, group4});

        return new University("YSU", "Alek Manukyan 1", new Faculty[]{faculty1, faculty2});
    }

    public static void getStudentsAverageMarkFromAllSubjects(Student student) {
        float averageValue = 0;
        if (checkStudentSubjects(student)) {
            throw new SubjectAbsenceException(student);
        }
        for (Mark mark : student.getMarks()) {
            averageValue += mark.getValue();
        }
        System.out.println(student.getFirstName() + " " + student.getLastName() + " - average mark from all subjects : "
                + averageValue / student.getMarks().length);
    }

    public static void getAverageMarkOfGroupFromSubject(Group group, String subject) {
        int countOfMarks = getMarksCount(group, subject);
        int marksTotalValue = getMarksTotalValue(group, subject);
        System.out.println("Group : " + group.getName() + " - average mark from " + subject + " : "
                + marksTotalValue / countOfMarks);
    }

    public static void getAverageMarkOfFacultyFromSubject(Faculty faculty, String subject) {
        int marksCount = getMarksCount(faculty, subject);
        int markTotalValue = getMarksTotalValue(faculty, subject);
        System.out.println("Faculty : " + faculty.getName() + " - average mark from " + subject + " : "
                + markTotalValue / marksCount);
    }

    public static void getAverageMarkOfUniversityFromSubject(University university, String subject) {
        int markCount = getMarksCount(university, subject);
        int marksTotalValues = getMarksTotalValue(university, subject);
        System.out.println("University : " + university.getName() + " - average mark from " + subject + " : "
                + marksTotalValues / markCount);
    }

    private static int getMarksCount(University university, String subject) {
        int quantityOfMarks = 0;
        if (checkUniversity(university)) {
            throw new FacultyAbsenceException(university);
        }
        for (Faculty faculty : university.getFaculties()) {
            quantityOfMarks += getMarksCount(faculty, subject);
        }
        return quantityOfMarks;
    }

    private static int getMarksTotalValue(University university, String subject) {
        int marksTotalValue = 0;
        if (checkUniversity(university)) {
            throw new FacultyAbsenceException(university);
        }
        for (Faculty faculty : university.getFaculties()) {
            marksTotalValue += getMarksCount(faculty, subject);
        }
        return marksTotalValue;
    }

    private static int getMarksCount(Faculty faculty, String subject) {
        int quantityOfMarks = 0;
        if (checkUniversityFaculties(faculty)) {
            throw new GroupAbsenceException(faculty);
        }
        for (Group group : faculty.getGroups()) {
            quantityOfMarks += getMarksCount(group, subject);
        }
        return quantityOfMarks;
    }

    private static int getMarksTotalValue(Faculty faculty, String subject) {
        int marksTotalValue = 0;
        if (checkUniversityFaculties(faculty)) {
            throw new GroupAbsenceException(faculty);
        }
        for (Group group : faculty.getGroups()) {
            marksTotalValue += getMarksCount(group, subject);
        }
        return marksTotalValue;
    }

    private static int getMarksCount(Group group, String subject) {
        int count = 0;
        if (checkGroupStudents(group)) {
            throw new StudentAbsenceException(group);
        }
        for (Student student : group.getStudents()) {
            for (Mark mark : student.getMarks()) {
                if (mark.getSubject().equals(subject)) {
                    ++count;
                }
            }
        }
        return count;
    }

    private static int getMarksTotalValue(Group group, String subject) {
        int sum = 0;
        if (checkGroupStudents(group)) {
            throw new StudentAbsenceException(group);
        }
        for (Student student : group.getStudents()) {
            for (Mark mark : student.getMarks()) {
                if (mark.getSubject().equals(subject)) {
                    sum += mark.getValue();
                }
            }
        }
        return sum;
    }

    private static boolean checkUniversity(University university) {
        return university.getFaculties() == null || university.getFaculties().length == 0;
    }

    private static boolean checkUniversityFaculties(Faculty faculty) {
        return (faculty.getGroups() == null || faculty.getGroups().length == 0);
    }

    private static boolean checkGroupStudents(Group group) {
        return (group.getStudents() == null || group.getStudents().length == 0);
    }

    private static boolean checkStudentSubjects(Student student) {
        return (student.getSubjects() == null || student.getSubjects().length == 0);
    }

    public static Faculty getRandomFaculty(University university) {
        return university.getFaculties()[new Random().nextInt(university.getFaculties().length)];
    }

    public static Group getRandomGroup(University university) {
        Faculty faculty = getRandomFaculty(university);
        return faculty.getGroups()[new Random().nextInt(faculty.getGroups().length)];
    }

    public static Student getRandomStudent(University university) {
        Group group = getRandomGroup(university);
        return group.getStudents()[new Random().nextInt(group.getStudents().length)];
    }

    public static String getRandomSubject() {
        return ALL_SUBJECTS[new Random().nextInt(ALL_SUBJECTS.length)];
    }
}