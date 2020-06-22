package com.philipramkeerat.travel.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

    public static final String DAY_MONTH = "dd/MM";

    public static String periodToText(int dias) {
        Calendar startDate = Calendar.getInstance();
        Calendar backDate = Calendar.getInstance();
        backDate.add(Calendar.DATE, dias);
        SimpleDateFormat brazilianFormat = new SimpleDateFormat(DAY_MONTH);
        String formatedStartDate = brazilianFormat.format(startDate.getTime());
        String formatedBackDate = brazilianFormat.format(backDate.getTime());
        return formatedStartDate + " - "
                + formatedBackDate + " de "
                + backDate.get(Calendar.YEAR);
    }
}
