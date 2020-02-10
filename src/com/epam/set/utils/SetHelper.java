package com.epam.set.utils;

import com.epam.set.model.Coffee;
import com.epam.set.model.Flower;
import com.epam.set.model.Student;

import java.util.Iterator;

public class SetHelper {

    //Creating Sets for MyLinkedList
    public static MyLinkedSet<Student> createStudentsLinkedSet() {
        MyLinkedSet<Student> myStudentLinkedSet = new MyLinkedSet<>();
        myStudentLinkedSet.add(new Student("Sargis", "Sargsyan", 20));
        myStudentLinkedSet.add(new Student("Abgar", "Sargsyan", 20));
        myStudentLinkedSet.add(new Student("Abc", "Sargsyan", 20));
        myStudentLinkedSet.add(new Student("William", "Sargsyan", 20));
        myStudentLinkedSet.add(new Student("Gago", "Sargsyan", 20));
        myStudentLinkedSet.add(new Student("Babken", "Sargsyan", 20));
        myStudentLinkedSet.add(new Student("Narek", "Sargsyan", 25));
        return myStudentLinkedSet;
    }

    public static MyLinkedSet<Coffee> createCoffeeLinkedSet() {
        MyLinkedSet<Coffee> myCoffeeLinkedSet = new MyLinkedSet<>();
        myCoffeeLinkedSet.add(new Coffee("black", "Torabika", "Africa"));
        myCoffeeLinkedSet.add(new Coffee("black", "Arabica", "America"));
        myCoffeeLinkedSet.add(new Coffee("brown", "Torabika", "China"));
        myCoffeeLinkedSet.add(new Coffee("darkbrown", "Arabica", "Brazil"));
        return myCoffeeLinkedSet;
    }

    public static MyLinkedSet<Flower> createFlowerLinkedSet() {
        MyLinkedSet<Flower> myFlowerLinkedSet = new MyLinkedSet<>();
        myFlowerLinkedSet.add(new Flower("Rose", "white"));
        myFlowerLinkedSet.add(new Flower("Lily", "yellow"));
        myFlowerLinkedSet.add(new Flower("Rose", "red"));
        myFlowerLinkedSet.add(new Flower("Orchids", "blue"));
        myFlowerLinkedSet.add(new Flower("Lily", "pink"));
        return myFlowerLinkedSet;
    }
}