package com.epam.exceptions;

import com.epam.models.Group;

public class StudentAbsenceException extends RuntimeException {
    private Group group;

    public StudentAbsenceException(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return group.getName()+" doesn't have any student";
    }
}
