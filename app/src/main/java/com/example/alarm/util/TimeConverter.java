package com.example.alarm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Recieves an Hour, and a Minute, and outputs those values as a Formatted String which
 *
 */
public class TimeConverter {

    public static String convertTime (int hour, int minute) throws ParseException {
        String alarmTime = Integer.toString(hour) + ":" + Integer.toString(minute);
        DateFormat inFormat = new SimpleDateFormat("HH:mm"); //HH for hour of the day (0 - 23)

        Date alarm;
        alarm = inFormat.parse(alarmTime);

        DateFormat outFormat = new SimpleDateFormat("h:mm a");
        return outFormat.format(alarm).toLowerCase();
    }

}