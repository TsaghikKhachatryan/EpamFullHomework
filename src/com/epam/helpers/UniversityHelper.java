package com.epam.helpers;

import com.epam.Exceptions.FacultyAbsenceException;
import com.epam.Exceptions.GroupAbsenceException;
import com.epam.Exceptions.StudentAbsenceException;
import com.epam.Exceptions.SubjectAbsenceException;
import com.epam.models.*;

import java.util.Random;

public class UniversityHelper {

    public static University creteTheUniversity() {
        String mathematics = "Mathematics";
        String english = "English";
        String armenian = "Armenian";
        String logic = "Logic";
        String sociology = "Sociology";
        String physics = "Physics";

        String[] subjectsOfGroup701 = new String[]{physics, sociology, armenian};
        String[] subjectsOfGroup702 = new String[]{mathematics, logic, sociology};
        String[] subjectsOfGroup501 = new String[]{english, logic, armenian};
        String[] subjectsOfGroup502 = new String[]{english, sociology, physics};

        Mark.MarkBuilder markBuilder = new Mark.MarkBuilder();
        markBuilder.subject(physics);
        Mark physicsA = markBuilder.value(5).build();
        Mark physicsB = markBuilder.value(4).build();
        Mark physicsC = markBuilder.value(3).build();

        markBuilder.subject(sociology);
        Mark sociologyA = markBuilder.value(5).build();
        Mark sociologyB = markBuilder.value(4).build();
        Mark sociologyC = markBuilder.value(3).build();

        markBuilder.subject(armenian);
        Mark armenianA = markBuilder.value(5).build();
        Mark armenianB = markBuilder.value(4).build();
        Mark armenianC = markBuilder.value(3).build();

        markBuilder.subject(mathematics);
        Mark mathematicsA = markBuilder.value(5).build();
        Mark mathematicsB = markBuilder.value(4).build();
        Mark mathematicsC = markBuilder.value(3).build();

        markBuilder.subject(logic);
        Mark logicA = markBuilder.value(5).build();
        Mark logicB = markBuilder.value(4).build();
        Mark logicC = markBuilder.value(3).build();

        markBuilder.subject(english);
        Mark englishA = markBuilder.value(5).build();
        Mark englishB = markBuilder.value(4).build();
        Mark englishC = markBuilder.value(3).build();

        Student.StudentBuilder studentBuilder701 = new Student.StudentBuilder(subjectsOfGroup701);
        Student student1 = studentBuilder701.firstName("Ani")
                .lastName("Poghosyan")
                .marks(new Mark[]{physicsB, sociologyC, armenianA})
                .build();

        Student student2 = studentBuilder701.firstName("Aram")
                .lastName("Nikoyan")
                .marks(new Mark[]{physicsC, sociologyC, armenianB, armenianB, physicsB})
                .build();

        Student student3 = studentBuilder701.firstName("Lilit")
                .lastName("Azizyan")
                .marks(new Mark[]{physicsA, sociologyA, armenianB, physicsA, sociologyB})
                .build();

        Student.StudentBuilder studentBuilder702 = new Student.StudentBuilder(subjectsOfGroup702);
        Student student4 = studentBuilder702.firstName("Anna")
                .lastName("Poghosyan")
                .marks(new Mark[]{mathematicsA, logicC, sociologyA, logicB})
                .build();

        Student student5 = studentBuilder702.firstName("Arman")
                .lastName("Nikoyan")
                .marks(new Mark[]{mathematicsA, logicA, sociologyB, mathematicsB, mathematicsC})
                .build();

        Student.StudentBuilder studentBuilder501 = new Student.StudentBuilder(subjectsOfGroup501);
        Student student6 = studentBuilder501.firstName("Karine")
                .lastName("Poghosyan")
                .marks(new Mark[]{logicC, armenianA, logicB, englishB})
                .build();

        Student student7 = studentBuilder501.firstName("Minas")
                .lastName("Nikoyan")
                .marks(new Mark[]{logicA, armenianA, logicB, englishC, armenianA, armenianC})
                .build();

        Student.StudentBuilder studentBuilder502 = new Student.StudentBuilder(subjectsOfGroup502);
        Student student8 = studentBuilder502.firstName("Marine")
                .lastName("Khachatryan")
                .marks(new Mark[]{sociologyA, sociologyA, englishB})
                .build();

        Student student9 = studentBuilder502.firstName("Davit")
                .lastName("Grigoryan")
                .marks(new Mark[]{physicsA, englishC, sociologyA, englishA})
                .build();

        Group group1 = new Group("701", new Student[]{student1, student2, student3});
        Group group2 = new Group("702", new Student[]{student4, student5});
        Group group3 = new Group("501", new Student[]{student6, student7});
        Group group4 = new Group("502", new Student[]{student8, student9});

        Faculty faculty1 = new Faculty("Applied Mathematics", new Group[]{group1, group2});
        Faculty faculty2 = new Faculty("romanGermanic", new Group[]{group3, group4});

        return new University("YSU", "Alek Manukyan 1", new Faculty[]{faculty1, faculty2});
    }

    public static void calculateStudentsAverageMarkFromAllSubjects(Student student) {
        float averageValue = 0;
        if (student.getSubjects() == null || student.getSubjects().length == 0) {
            throw new SubjectAbsenceException(student);
        }
        for (Mark mark : student.getMarks()) {
            averageValue += mark.getValue();
        }
        System.out.println(student.getFirstName() + " " + student.getLastName() + " - average mark from all subjects : "
                + averageValue / student.getMarks().length);
    }

    public static void calculateAverageMarkOfGroupFromSubject(Group group, String subject) {
        float averageValue = 0;
        int quantityOfMarks = 0;
        if (group.getStudents() == null || group.getStudents().length == 0) {
            throw new StudentAbsenceException(group);
        }
        for (Student student : group.getStudents()) {
            for (Mark mark : student.getMarks()) {
                if (mark.getSubject().equals(subject)) {
                    averageValue += mark.getValue();
                    ++quantityOfMarks;
                }
            }
        }
        System.out.println("Group : " + group.getName() + " - average mark from " + subject + " : "
                + averageValue / quantityOfMarks);
    }

    public static void calculateAverageMarkOfFacultyFromSubject(Faculty faculty, String subject) {
        float averageValue = 0;
        int quantityOfMarks = 0;
        if (faculty.getGroups() == null || faculty.getGroups().length == 0) {
            throw new GroupAbsenceException(faculty);
        }
        for (Group group : faculty.getGroups()) {
            if (group.getStudents() == null || group.getStudents().length == 0) {
                throw new StudentAbsenceException(group);
            }
            for (Student student : group.getStudents()) {
                for (Mark mark : student.getMarks()) {
                    if (mark.getSubject().equals(subject)) {
                        averageValue += mark.getValue();
                        ++quantityOfMarks;
                    }
                }
            }
        }
        System.out.println("Faculty : " + faculty.getName() + " - average mark from " + subject + " : "
                + averageValue / quantityOfMarks);
    }

    public static void calculateAverageMarkOfUniversityFromSubject(University university, String subject)
            throws FacultyAbsenceException {

        float averageValue = 0;
        int quantityOfMarks = 0;
        if (university.getFaculties() == null || university.getFaculties().length == 0) {
            throw new FacultyAbsenceException(university);
        }
        for (Faculty faculty : university.getFaculties()) {
            if (faculty.getGroups() == null || faculty.getGroups().length == 0) {
                throw new GroupAbsenceException(faculty);
            }
            for (Group group : faculty.getGroups()) {
                if (group.getStudents() == null || group.getStudents().length == 0) {
                    throw new StudentAbsenceException(group);
                }
                for (Student student : group.getStudents()) {
                    for (Mark mark : student.getMarks()) {
                        if (mark.getSubject().equals(subject)) {
                            averageValue += mark.getValue();
                            ++quantityOfMarks;
                        }
                    }
                }
            }
        }
        System.out.println("University : " + university.getName() + " - average mark from " + subject + " : "
                + averageValue / quantityOfMarks);
    }

    public static Student getRandomStudent(University university) {
        Group group = getRandomGroup(university);
        Random rand = new Random();
        int rand_int = rand.nextInt(group.getStudents().length);
        return group.getStudents()[rand_int];
    }

    public static Student getRandomStudent(Group group) {
        Random rand = new Random();
        int rand_int = rand.nextInt(group.getStudents().length);
        return group.getStudents()[rand_int];
    }

    public static String getRandomSubject(University university) {
        Faculty faculty = getRandomFaculty(university);
        return getRandomSubject(faculty);
    }

    public static String getRandomSubject(Faculty faculty) {
        Group group = getRandomGroup(faculty);
        return getRandomSubject(group);
    }

    public static String getRandomSubject(Group group) {
        Student student = getRandomStudent(group);
        Random rand = new Random();
        int rand_int = rand.nextInt(student.getSubjects().length);
        return student.getSubjects()[rand_int];
    }

    public static Group getRandomGroup(University university) {
        Faculty faculty = getRandomFaculty(university);
        Random rand = new Random();
        int rand_int = rand.nextInt(faculty.getGroups().length);
        return faculty.getGroups()[rand_int];
    }

    public static Faculty getRandomFaculty(University university) {
        Random rand = new Random();
        int rand_int = rand.nextInt(university.getFaculties().length);
        return university.getFaculties()[rand_int];
    }

    public static Group getRandomGroup(Faculty faculty) {
        Random rand = new Random();
        int rand_int = rand.nextInt(faculty.getGroups().length);
        return faculty.getGroups()[rand_int];
    }
}