package models;

public class Faculty {
    private String name;
    private Group[] groups;

    public Faculty(String name, Group[] groups) {
        this.name = name;
        this.groups = groups;
    }

    public Group[] getGroups() {
        return groups;
    }
}
