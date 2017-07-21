package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String weekDay = "";

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sNumber = bf.readLine();
        int iNumber = Integer.parseInt(sNumber);

        switch (iNumber) {
            case 1:
                weekDay = "понедельник";
                break;
            case 2:
                weekDay = "вторник";
                break;
            case 3:
                weekDay = "среда";
                break;
            case 4:
                weekDay = "четверг";
                break;
            case 5:
                weekDay = "пятница";
                break;
            case 6:
                weekDay = "суббота";
                break;
            case 7:
                weekDay = "воскресенье";
                break;
            default:
                weekDay = "такого дня недели не существует";
                break;
        }

        System.out.println(weekDay);


    }
}