package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = new String[10];
        int[] lineLenght = new int[10];

        for (int i = 0; i < lines.length; i++) {
            lines[i] = bf.readLine();
            lineLenght[i] = lines[i].length();
        }

        for (int b = 0; b < lines.length; b++) {
            System.out.println(lineLenght[b]);
        }
    }
}
