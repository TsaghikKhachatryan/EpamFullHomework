package models;

public class University {
    private String name;
    private String address;
    private Faculty[] faculties;

    public University(String name, String address, Faculty[] faculties) {
        this.name = name;
        this.address = address;
        this.faculties = faculties;
    }

    public Faculty[] getFaculties() {
        return faculties;
    }
}
