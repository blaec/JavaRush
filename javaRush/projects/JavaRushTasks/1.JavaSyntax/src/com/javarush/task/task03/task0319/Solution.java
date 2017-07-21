package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine();
        String sSum = bufferedReader.readLine();
        int iSum = Integer.parseInt(sSum);
        String sYear = bufferedReader.readLine();
        int iYear = Integer.parseInt(sYear);

        System.out.println(name + " получает " + iSum + " через " + iYear + " лет.");
    }
}
