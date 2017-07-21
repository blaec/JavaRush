package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        HashMap<String, String> months = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        months.put("January"," is 1 month");
        months.put("February"," is 2 month");
        months.put("March"," is 3 month");
        months.put("April"," is 4 month");
        months.put("May"," is 5 month");
        months.put("June"," is 6 month");
        months.put("July"," is 7 month");
        months.put("August"," is 8 month");
        months.put("September"," is 9 month");
        months.put("October"," is 10 month");
        months.put("November"," is 11 month");
        months.put("December"," is 12 month");

        String month = reader.readLine();
        System.out.println(month + months.get(month));

    }
}
