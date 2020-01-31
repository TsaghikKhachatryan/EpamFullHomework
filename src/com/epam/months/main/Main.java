package com.epam.months.main;

import com.epam.months.models.Months;
import com.epam.months.util.MonthsHelper;

public class Main {
    public static void main(String[] args) {
        manageMonths();
    }

    private static void manageMonths() {
        MonthsHelper.printHolidaysOfMonth(Months.APRIL);
        MonthsHelper.printDayCountOfMonth(Months.MARCH);
        MonthsHelper.printAllMonths();
        boolean isMarch21Holiday= MonthsHelper.checkIfHoliday(21,Months.MARCH);
        System.out.println("Is March 21 holiday: " + isMarch21Holiday);
        boolean isMarch8Holiday= MonthsHelper.checkIfHoliday(8,Months.MARCH);
        System.out.println("Is March 8 holiday: " + isMarch8Holiday);
    }
}
