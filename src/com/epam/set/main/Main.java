package com.epam.set.main;

import com.epam.set.model.Coffee;
import com.epam.set.model.Flower;
import com.epam.set.model.Student;
import com.epam.set.utils.MyLinkedSet;
import com.epam.set.utils.MySet;
import com.epam.set.utils.SetHelper;

public class Main {
    public static void main(String[] args) {
        manageMySet();
    }

    private static void manageMySet() {
        MyLinkedSet<Student> mystudentLinkedSet = SetHelper.createStudentsLinkedSet();
        MyLinkedSet<Coffee> myCoffeeLinkedSet = SetHelper.createCoffeeLinkedSet();
        MyLinkedSet<Flower> myFlowerLinkedSet = SetHelper.createFlowerLinkedSet();
        System.out.println("printing Coffee's set");
        myCoffeeLinkedSet.print();
        System.out.println();
        System.out.println("printing Flower's set");
        myFlowerLinkedSet.print();
        System.out.println();
        System.out.printf("printing Student's set");
        mystudentLinkedSet.print();
        System.out.println();
        mystudentLinkedSet.remove(new Student("Babken", "Sargsyan", 20));
        System.out.println("printing Students Set after removing");
        mystudentLinkedSet.print();
    }
}
