package com.epam.university.models;

public class Student {
    private String firstName;
    private String lastName;
    private String[] subjects;
    private Mark[] marks;

    private Student(StudentBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.subjects = builder.subjects;
        this.marks = builder.marks;
    }

    public static class StudentBuilder {
        private String firstName;
        private String lastName;
        private String[] subjects;
        private Mark[] marks;

        public StudentBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder marks(Mark[] marks) {
            this.marks = marks;
            return this;
        }

        public StudentBuilder subject(String[] subjects) {
            this.subjects = subjects;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public Mark[] getMarks() {
        return marks;
    }
}
