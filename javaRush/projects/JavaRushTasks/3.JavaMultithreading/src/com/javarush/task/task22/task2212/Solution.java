package com.javarush.task.task22.task2212;

import java.util.ArrayList;
import java.util.List;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        // 7. Ends with digit
//        if (telNumber.matches("\\d+$"))    return true;
//        if (telNumber.matches("\\+\\d{12}"))    return true;
//        if (telNumber.matches("[(]\\d{9}") || telNumber.matches("\\d{10}"))
//                                                       return true;
//        if (telNumber.matches("[-]{0,2}"))    return true;
//
//        if (telNumber.matches(""))    return true;
//        if (telNumber.matches(""))    return true;

        // 6. No letters
        if (telNumber.matches("[^a-zA-Z]*"))    return true;

        return false;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("+380501234567");
        test.add("+38(050)1234567");
        test.add("+38050123-45-67");
        test.add("050123-4567");
        test.add("+38)050(1234567");
        test.add("+38(050)1-23-45-6-7");
        test.add("050ххх4567");
        test.add("050123456");
        test.add("(0)501234567");
        test.add("0123456789");
        test.add("abc");

        for (String phone : test){
            System.out.println(phone + " - " + checkTelNumber(phone));
        }

    }
}
