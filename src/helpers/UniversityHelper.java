package helpers;

import models.*;

public class UniversityHelper {
    public static University university;

    public static void creteTheUniversity() {
        Subject mathematics = new Subject("Mathematics");
        Subject english = new Subject("English");
        Subject armenian = new Subject("Armenian");
        Subject logic = new Subject("Logic");
        Subject sociology = new Subject("Sociology");
        Subject physics = new Subject("Physics");

        Subject[] subjectsOfGroup701 = new Subject[]{physics, sociology, armenian};
        Subject[] subjectsOfGroup702 = new Subject[]{mathematics, logic, sociology};
        Subject[] subjectsOfGroup501 = new Subject[]{english, logic, armenian};
        Subject[] subjectsOfGroup502 = new Subject[]{english, sociology, physics};

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

        university = new University("YSU", "Alek Manukyan 1", new Faculty[]{faculty1, faculty2});
    }

    public static float calculateStudentsAverageMarkFromAllSubjects(Student student) {
        float averageValue = 0;
        for (Mark mark : student.getMarks()) {
            averageValue += mark.getValue();
        }
        return averageValue / student.getMarks().length;
    }

    public static float calculateStudentsAverageMarkOfGroupFromSubject(Group group, Subject subject) {
        float averageValue = 0;
        int quantityOfMarks = 0;
        for (Student student : group.getStudents()) {
            for (Mark mark : student.getMarks()) {
                if (mark.getSubject().equals(subject)) {
                    averageValue += mark.getValue();
                    ++quantityOfMarks;
                }
            }
        }
        return averageValue / quantityOfMarks;
    }

    public static float calculateStudentsAverageMarkOfFacultyFromSubject(Faculty faculty, Subject subject) {
        float averageValue = 0;
        int quantityOfMarks = 0;
        for (Group group : faculty.getGroups()) {
            for (Student student : group.getStudents()) {
                for (Mark mark : student.getMarks()) {
                    if (mark.getSubject().equals(subject)) {
                        averageValue += mark.getValue();
                        ++quantityOfMarks;
                    }
                }
            }
        }
        return averageValue / quantityOfMarks;
    }

    public static float calculateStudentsAverageMarkOfUniversityFromSubject(University university, Subject subject) {
        float averageValue = 0;
        int quantityOfMarks = 0;
        for (Faculty faculty : university.getFaculties()) {
            for (Group group : faculty.getGroups()) {
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
        return averageValue / quantityOfMarks;
    }
}
