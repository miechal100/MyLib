package com.example.mylib.MyLib.utils;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Component
public class DateUtils {

    private static final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    public static Date now() {
        return calendar.getTime();
    }
}
