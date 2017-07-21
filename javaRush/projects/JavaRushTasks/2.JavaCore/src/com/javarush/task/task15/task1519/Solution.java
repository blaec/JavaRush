package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код\
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("exit")) {
            if (line.contains(".")  && isDouble(line))
                print(Double.parseDouble(line));
            else if (isShort(line))
                print(Short.parseShort(line));
            else if (isInteger(line))
                print(Integer.parseInt(line));
            else
                print(line);
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }


    public static boolean isDouble( String str ){
        try {
            Double.parseDouble(str);
            return true;
        } catch( Exception e){
            return false;
        }
    }

    public static boolean isShort( String str ) {
        try {
            short num = Short.parseShort(str);
            if (num > 0 && num < 128)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isInteger( String str ) {
        try {
            int num = Integer.parseInt(str);
            if (num <= 0 || num >= 128)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
}
