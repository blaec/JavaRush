package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        // Validate string
        if (string == null || string.isEmpty()) throw new TooShortStringException();

        // Split string and validate count of tabs
        String[] tokens = string.split("\t");
        if (tokens.length < 3) throw new TooShortStringException();

        return tokens[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
