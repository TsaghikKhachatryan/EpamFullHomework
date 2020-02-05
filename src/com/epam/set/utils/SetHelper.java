package com.epam.set.utils;

import com.epam.set.model.Coffee;
import com.epam.set.model.Flower;
import com.epam.set.model.Student;

import java.util.Iterator;

public class SetHelper {
    public static MySet<Student> createStudentsSet() {
        MySet<Student> myStudentSet = new MySet<>();
        myStudentSet.add(new Student("Abov", "Sargsyan", 20));
        myStudentSet.add(new Student("Ani", "Sargsyan", 80));
        myStudentSet.add(new Student("Ani", "Sargsyan", 27));
        myStudentSet.add(new Student("Poghos", "Poghosyan", 21));
        myStudentSet.add(new Student("Poghos", "Poghosyan", 21));
        myStudentSet.add(new Student("Sargis", "Meloyan", 25));
        myStudentSet.add(new Student("Anna", "Mnoyan", 30));
        return myStudentSet;
    }

    public static MySet<Flower> createFlowerSet() {
        MySet<Flower> myFlowerSet = new MySet<>();
        myFlowerSet.add(new Flower("Rose", "white"));
        myFlowerSet.add(new Flower("Lily", "yellow"));
        myFlowerSet.add(new Flower("Rose", "red"));
        myFlowerSet.add(new Flower("Orchids", "blue"));
        myFlowerSet.add(new Flower("Lily", "pink"));
        return myFlowerSet;
    }

    public static MySet<Coffee> createCoffeeSet() {
        MySet<Coffee> myCoffeeSet = new MySet<>();
        myCoffeeSet.add(new Coffee("black", "Torabika", "Africa"));
        myCoffeeSet.add(new Coffee("black", "Arabica", "America"));
        myCoffeeSet.add(new Coffee("brown", "Torabika", "China"));
        myCoffeeSet.add(new Coffee("darkbrown", "Arabica", "Brazil"));
        return myCoffeeSet;
    }

    public static void printSet(MySet mySet) {
        Iterator iterator = mySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }
}