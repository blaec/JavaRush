package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the string from the left to ? char and split this string to substrings separated with &
        String[] parameters = (input.substring(input.indexOf('?') + 1, input.length())).split("&");

        String[] parameter = null;
        StringBuilder sb = new StringBuilder();
        String objMethod = null;
        int objPos = -1;
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].contains("=")) {
                parameter = parameters[i].split("=");
                sb.append(parameter[0] + " ");
            }
            else
                sb.append(parameters[i] + " ");
            if (parameters[i].contains("obj"))
                objMethod = parameters[i].split("=")[1];

            //if (i > 0) sb.append(" " + parameter[0]);
            //else sb.append(parameter[0]);
        }

        System.out.println(sb);
        if (objMethod != null) {
            if (isDouble(objMethod))
                alert(Double.parseDouble(objMethod));
            else
                alert(objMethod);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    public static boolean isDouble( String str ){
        try {
            Double.parseDouble(str);
            return true;
        } catch( Exception e){
            return false;
        }
    }
}
