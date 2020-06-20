package com.philipramkeerat.travel.util;

public class DaysUtil {

    public static final String PLURAL_DAYS = " days";
    public static final String SINGULAR_DAYS = " day";

    public static String formatInText(int quantityOfDays) {
        String daysText = "";
        if (quantityOfDays > 1) {
            return quantityOfDays + PLURAL_DAYS;
        }
        return quantityOfDays + SINGULAR_DAYS;
    }
}
