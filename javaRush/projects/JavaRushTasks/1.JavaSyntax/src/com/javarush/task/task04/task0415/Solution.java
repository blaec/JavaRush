package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sA = br.readLine();
        String sB = br.readLine();
        String sC = br.readLine();
        int iA = Integer.parseInt(sA);
        int iB = Integer.parseInt(sB);
        int iC = Integer.parseInt(sC);

        String result = "Треугольник существует.";
        if (iA + iB <= iC || iA + iC <= iB || iB + iC <= iA)
            result = "Треугольник не существует.";

        System.out.println(result);
    }
}