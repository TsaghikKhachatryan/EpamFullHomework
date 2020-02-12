package com.epam.threads.main;

import com.epam.threads.utils.NameHelper;
import com.epam.threads.utils.NameThread;

public class Main {

    public static void main(String[] args) {
        NameHelper nameHelper = new NameHelper();
        NameThread a = new NameThread(nameHelper, 0);
        NameThread b = new NameThread(nameHelper, 1);
        NameThread c = new NameThread(nameHelper, 2);

        a.start();
        b.start();
        c.start();
    }
}
