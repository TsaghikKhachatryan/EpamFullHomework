package models;

public class Group {
    private String name;
    private Student[] students;

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }
}
