package com.epam.collections.models;

public class Student implements Comparable {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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
        return this.lastName.compareTo(((Student)object).lastName);
    }
}