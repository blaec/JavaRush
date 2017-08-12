package com.javarush.task.task22.task2202;


/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {

        // validate string
        if (string == null || string.isEmpty()) throw new TooShortStringException();

        // Count spaces
        String[] tokens = string.split(" ");
        if (tokens.length < 5) throw new TooShortStringException();

        // Create output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            sb.append(tokens[i]).append(" ");
        }

        return sb.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
