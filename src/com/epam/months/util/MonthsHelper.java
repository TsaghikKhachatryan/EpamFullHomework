package com.epam.months.util;

import com.epam.months.models.Months;

public class MonthsHelper {

    public static void printDayCountOfMonth(Months month) {
        System.out.println(month + "days count is: " + month.getDAYS_COUNT());
    }

    public static void printHolidaysOfMonth(Months month) {
        System.out.println(month + " holidays are: ");
        for (Integer holiday : month.getHLOIDAYS_LIST()) {
            System.out.println(holiday);
        }
    }

    public static void printAllMonths() {
        Months[] months = Months.values();
        for (Months month : months) {
            System.out.println(month);
        }
    }

    public static boolean checkIfHoliday(int day, Months month) {
        for (int i = 0; i <month.getHLOIDAYS_LIST().length; i++) {
            if(month.getHLOIDAYS_LIST()[i]==day){
                return true;
            }
        }
        return false;
    }
}
