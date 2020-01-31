package com.epam.months.models;

import java.util.ArrayList;

public enum Months {
    JANUARY(31,new ArrayList<>(){{add(1);add(6);add(13);}}),
    FEBRUARY(28,new ArrayList<>(){{add(23);}}),
    MARCH(31,new ArrayList<>(){{add(8);add(22);add(24);}}),
    APRIL(30,new ArrayList<>(){{add(7);add(24);}}),
    MAY(31,new ArrayList<>(){{add(1);add(9);add(28);}}),
    JUNE(30,new ArrayList<>(){{add(1);add(7);}}),
    JULY(31,new ArrayList<>(){{add(7);add(23);add(14);}}),
    AUGUST(31,new ArrayList<>(){{add(10);add(20);add(26);}}),
    SEPTEMBER(30,new ArrayList<>(){{add(1);add(7);add(24);}}),
    OCTOBER(31,new ArrayList<>(){{add(24);}}),
    NOVEMBER(30,new ArrayList<>(){{add(14);}}),
    DECEMBER(31,new ArrayList<>(){{add(1);add(15);add(13);}});

    private final int DAYS_COUNT;
    private final ArrayList<Integer> HLOIDAYS_LIST;

    Months(int DAYS_COUNT, ArrayList<Integer> HLOIDAYS_LIST) {
        this.DAYS_COUNT = DAYS_COUNT;
        this.HLOIDAYS_LIST = HLOIDAYS_LIST;
    }

    public ArrayList<Integer> getHLOIDAYS_LIST() {
        return HLOIDAYS_LIST;
    }

    public int getDAYS_COUNT() {
        return DAYS_COUNT;
    }
}
