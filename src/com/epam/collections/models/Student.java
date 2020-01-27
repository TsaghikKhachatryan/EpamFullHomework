package com.epam.collections.models;

public class Student implements Comparable {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Student(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName +
                " " + this.age;
    }

    @Override
    public int compareTo(Object object) {
        return this.lastName.compareTo(((Student) object).lastName);
    }

    @Override
    public boolean equals(Object object) {
        return this.getId() == ((Student) object).getId();
    }
}