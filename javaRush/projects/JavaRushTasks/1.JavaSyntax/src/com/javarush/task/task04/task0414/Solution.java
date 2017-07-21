package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int DaysInYear = 366;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sYear = bf.readLine();
        int iYear = Integer.parseInt(sYear);

        if (iYear % 4 != 0)
            DaysInYear = 365;
        else if (iYear % 100 == 0 & iYear % 400 != 0)
            DaysInYear = 365;

        System.out.println("количество дней в году: " + DaysInYear);
    }
}