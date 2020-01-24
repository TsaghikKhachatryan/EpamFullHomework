package com.epam.university.models;

public class Faculty {
    private String name;
    private Group[] groups;

    public Faculty(String name, Group[] groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public Group[] getGroups() {
        return groups;
    }
}
