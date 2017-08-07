package com.javarush.task.task40.task4008;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
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
        boolean hasDate = date.contains(".");
        boolean hasTime = date.contains(":");
        String dateFormat = "d.M.yyyy";
        String timeFormat = "H:m:s";
        DateTimeFormatter formatter = null;
        LocalDate localDate = null;
        LocalTime localTime = null;

        String[] dates = date.split(" ");

        if (hasDate) {
            formatter = DateTimeFormatter.ofPattern(dateFormat);
            localDate = LocalDate.parse(dates[0], formatter);
        }
        if (hasTime) {
            String time = dates.length > 1 ? dates[1] : dates[0];
            formatter = DateTimeFormatter.ofPattern(timeFormat);
            localTime = LocalTime.parse(time, formatter);
        }

        if (hasDate) {
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            // 2nd option, for some reason - accepts non-adjusted ChronoField, although output is incorrect
//            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя месяца: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
//            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Неделя года: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
            System.out.println("Месяц: " + localDate.getMonth().getValue());
            System.out.println("Год: " + localDate.getYear());
        }
        if (hasTime) {
            String amPm = localTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM";
            System.out.println("AM или PM: " + amPm);
            System.out.println("Часы: " + localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
        }
    }
}
