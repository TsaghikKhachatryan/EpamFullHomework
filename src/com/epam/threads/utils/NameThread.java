package com.epam.threads.utils;

public class NameThread extends Thread {
    private final int PRINT_COUNT = 20;
    private int index;
    private NameHelper nameHelper;

    public NameThread(NameHelper nameHelper, int index) {
        this.nameHelper = nameHelper;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            synchronized (nameHelper) {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    while (nameHelper.currentIndex % 3 != index) {
                        nameHelper.wait();
                    }
                    NameHelper.printName(index);
                    ++nameHelper.currentIndex;
                    nameHelper.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
}

