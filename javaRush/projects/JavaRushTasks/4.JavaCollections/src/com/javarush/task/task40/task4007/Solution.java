package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
       boolean hasTime = date.contains(":");
       boolean hasDate = date.contains(".");
       String dateFormat = null;

       if (hasDate && hasTime)  dateFormat = "dd.MM.yy HH:mm:ss";
       else if (hasDate)        dateFormat = "dd.MM.yy";
       else if (hasTime)        dateFormat = "HH:mm:ss";
       else                     return;

        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            calendar.setTime(format.parse(date));
        } catch (ParseException e) { }

        if (hasDate) {
            System.out.println("День: " + calendar.get(Calendar.DATE));
            int defaultDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            int validDayOfWeek = defaultDayOfWeek == 0 ? 7 : defaultDayOfWeek;
            System.out.println("День недели: " + validDayOfWeek);
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
        }
        if (hasTime) {
            String amPm = calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM";
            System.out.println("AM или PM: " + amPm);
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }
    }
}
