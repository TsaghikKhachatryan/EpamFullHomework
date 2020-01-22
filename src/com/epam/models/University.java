package com.epam.models;

public class University {
    private String name;
    private String address;
    private Faculty[] faculties;

    public University(String name, String address, Faculty[] faculties) {
        this.name = name;
        this.address = address;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Faculty[] getFaculties() {
        return faculties;
    }
}
