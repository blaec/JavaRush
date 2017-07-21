package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sMinutes = bf.readLine();
        double dMinutes = Double.parseDouble(sMinutes);

        String light = "красный";
        double range = dMinutes % 5;
        if (range < 3)
            light ="зелёный";
        else if (range < 4)
            light ="желтый";

        System.out.println(light);

    }
}