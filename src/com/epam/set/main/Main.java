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
        MySet<Student> myStudentSet= SetHelper.createStudentsSet();
        MySet<Coffee> myCoffeeSet= SetHelper.createCoffeeSet();
        MySet<Flower> myFlowerSet= SetHelper.createFlowerSet();
        System.out.println("Student's Set");
        SetHelper.printSet(myStudentSet);
        System.out.println("Coffe's Set");
        SetHelper.printSet(myCoffeeSet);
        System.out.println("Flower's Set");
        SetHelper.printSet(myFlowerSet);
        MyLinkedSet<Student> studentMyLinkedSet=SetHelper.createStudentsLinkedSet();
        studentMyLinkedSet.print();
        studentMyLinkedSet.remove(new Student("Sargis", "Sargsyan", 20));
    }
}
