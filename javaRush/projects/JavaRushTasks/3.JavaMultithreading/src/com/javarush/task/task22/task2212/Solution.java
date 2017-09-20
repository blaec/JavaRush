package com.javarush.task.task22.task2212;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        // If null string or length less then 10
        if (telNumber == null || telNumber.length() < 10){
            System.out.print("first - ");
            return false;
        }

        // If starts with + then it contains 12 digits
        if (telNumber.matches("^\\+[0-9]{12}")){
            System.out.print("^\\+[0-9]{12} - ");
            return true;
        }

        // Parenthes contain 3 digits
        // but in this case + 2 digits (3 digits) 7 digits [total 12 digits]
        if (telNumber.matches("^\\+[0-9]{2}\\([0-9]{3}\\)\\d{7}")){
            System.out.print("^\\+[0-9]{2}\\([0-9]{3}\\)\\d{7} - ");
            return true;
        }

        // Can contain 0-2 "-", can't go together
        // not exactly + 8 digits - 2 digits - 2 digits
        if(telNumber.matches("^\\+[0-9]{8}-\\d{2}-\\d{2}")){
            System.out.print("^\\+[0-9]{8}-\\d{2}-\\d{2} - ");
            return true;
        }

        // 6 digits - 4 digits
        if (telNumber.matches("^[0-9]{6}-[0-9]{4}")){
            System.out.print("^[0-9]{6}-[0-9]{4} - ");
            return true;
        }

        // Number does not contain letters
        // Number ends with digit
        System.out.print("last - ");
        return false;

        // If starts with digit or ( - then it contains 10 digits
        // Can contain pair of parenthes, which always to the left of "-"
    }

    public static void main(String[] args) {
        System.out.println("+380501234567 " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567 " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 " + checkTelNumber("(0)501234567"));
    }
}
