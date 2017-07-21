package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {

        // set the date
        Date date1 = new Date(date);

        // get calendar and set it to this date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);

        // get number of days from the beginning of year to this day
        cal.get(Calendar.DAY_OF_YEAR);
        return ((cal.get(Calendar.DAY_OF_YEAR) + 1) % 2 == 0);
        /*
        Date date1 = new Date(date);
        //Date date1 = new SimpleDateFormat("MMM d yyyy").parse(date);
        int year = date1.getYear();
        Date date0 = new Date();
        date0.setSeconds(0);
        date0.setMinutes(0);
        date0.setHours(0);
        date0.setDate(1);
        date0.setMonth(0);
        date0.setYear(year);
        long msDistance = date1.getTime() - date0.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int daysPassed = (int) (msDistance / msDay);
        return !(daysPassed % 2 == 0);
        */
    }
}
