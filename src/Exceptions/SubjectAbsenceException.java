package Exceptions;

import models.Student;

public class SubjectAbsenceException extends RuntimeException {
    private Student student;

    public SubjectAbsenceException(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return student.getFirstName() + " " + student.getLastName() + " doesn't have any subject";
    }
}
