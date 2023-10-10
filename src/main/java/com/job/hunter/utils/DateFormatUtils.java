package com.job.hunter.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateFormatUtils {

    private static final DateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");

    public static String formatDate(Long milliseconds) {
        return dateFormat.format(milliseconds);
    }
}
