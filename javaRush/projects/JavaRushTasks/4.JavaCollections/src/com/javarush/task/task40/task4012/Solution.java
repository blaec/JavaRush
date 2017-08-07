package com.javarush.task.task40.task4012;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(isLeap(localDate));
        System.out.println(isBefore(LocalDateTime.of(2014,10,10,10,10)));
        System.out.println(isBefore(LocalDateTime.of(3014,10,10,10,10)));
        System.out.println(addTime(LocalTime.of(10,10,10), 5, ChronoUnit.MINUTES));
        System.out.println(getPeriodBetween(LocalDate.now(), LocalDate.now().plusYears(2)));
        System.out.println(getPeriodBetween(LocalDate.now(), LocalDate.now().plusMonths(-2)));
    }

    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }

    // https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoUnit.html
    // http://www.java2s.com/Tutorials/Java/Data_Type_How_to/Date/Add_duration_to_date_and_check_exception.htm
    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        LocalDate startDate = firstDate.isBefore(secondDate) ? firstDate : secondDate;
        LocalDate endDate = firstDate.isBefore(secondDate) ? secondDate : firstDate;
        return Period.between(startDate, endDate);
    }
}
