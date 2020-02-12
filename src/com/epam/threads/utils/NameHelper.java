package com.epam.threads.utils;

public class NameHelper {
    public volatile int currentIndex = 0;
    private static String[] names = new String[]{"Diana", "Vahe", "Grish"};

    public static void printName(int index) {
        System.out.println(names[index]);
    }
}


