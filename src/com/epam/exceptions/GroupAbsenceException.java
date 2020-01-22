package com.epam.exceptions;

import com.epam.models.Faculty;

public class GroupAbsenceException extends RuntimeException {
    private Faculty faculty;

    public GroupAbsenceException(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return faculty.getName()+" doesn't have groups!";
    }
}