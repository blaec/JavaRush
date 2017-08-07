package com.javarush.task.task40.task4009;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(weekDayOfBirthday("30.05.1984", "2015"));
        System.out.println(weekDayOfBirthday("1.12.2015", "2016"));
    }

    public static String weekDayOfBirthday(String birthday, String year) {

        // parse string to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate localDate = LocalDate.parse(birthday, formatter);

        // get the date of birthday by year
        localDate = localDate.with(Year.parse(year));

        // return italian "birthday of week", but this does not fit validation 2nd point
//        LocalDate birthDate = LocalDate.of(Integer.parseInt(year), localDate.getMonth(), localDate.getDayOfMonth());
//        return birthDate.format(DateTimeFormatter.ofPattern("EEEE",Locale.ITALIAN));

        // optional solution
//        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.ITALIAN).format(localDate).split(" ")[0]);
       return localDate.format(DateTimeFormatter.ofPattern("EEEE",Locale.ITALIAN));
    }
}
