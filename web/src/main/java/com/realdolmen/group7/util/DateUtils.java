package com.realdolmen.group7.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public abstract class DateUtils {
    public static Date createDate(String pattern) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(pattern);
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse date", e);
        }
    }


    public static Date createDateAndTime(String yyyyMMdd_HHmmss) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(yyyyMMdd_HHmmss);
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse date", e);
        }
    }



    public static long yearsFrom(Date date) {
        LocalDate d = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.YEARS.between(d, LocalDate.now());
    }

    public static String longDateToStringDate(long input) {
        Date date = new Date(input);
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        return df2.format(date);
    }
}
