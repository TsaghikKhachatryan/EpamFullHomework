package com.epam.months.models;

import java.util.ArrayList;

public enum Months {
    JANUARY(31, new int[]{1, 6, 13, 31}),
    FEBRUARY(28, new int[]{5, 23, 26}),
    MARCH(31, new int[]{8, 12, 13}),
    APRIL(30, new int[]{7, 15, 24}),
    MAY(31, new int[]{1, 9, 28}),
    JUNE(30, new int[]{1, 7}),
    JULY(31, new int[]{2, 13}),
    AUGUST(31, new int[]{10, 20, 26, 31}),
    SEPTEMBER(30, new int[]{1, 21}),
    OCTOBER(31, new int[]{12}),
    NOVEMBER(30, new int[]{6, 18}),
    DECEMBER(31, , new int[]{1, 7, 31});

    private final int DAYS_COUNT;
    private final int[] HLOIDAYS_LIST;

    Months(int DAYS_COUNT, int[] HLOIDAYS_LIST) {
        this.DAYS_COUNT = DAYS_COUNT;
        this.HLOIDAYS_LIST = HLOIDAYS_LIST;
    }

    public int[] getHLOIDAYS_LIST() {
        return HLOIDAYS_LIST;
    }

    public int getDAYS_COUNT() {
        return DAYS_COUNT;
    }
}
