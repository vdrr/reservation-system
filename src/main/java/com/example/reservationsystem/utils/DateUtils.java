package com.example.reservationsystem.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static Date parseDate(String s) {
        try {
            return DATE_FORMATTER.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }
}
