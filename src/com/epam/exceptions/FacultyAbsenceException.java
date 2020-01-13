package com.epam.Exceptions;

import com.epam.models.University;

public class FacultyAbsenceException extends Exception {
    private University university;

    public FacultyAbsenceException(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return university.getName()+" doesn't have faculty!";
    }
}