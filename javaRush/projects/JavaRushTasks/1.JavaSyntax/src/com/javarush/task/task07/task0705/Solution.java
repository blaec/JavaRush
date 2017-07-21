package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] bigNumbers = new int[20];
        int[] halfFirst = new int[10];
        int[] halfSecond = new int[10];

        for (int i = 0; i < bigNumbers.length; i++) {
            bigNumbers[i] = Integer.parseInt(bf.readLine());

            if (i < 10)
                halfFirst[i] = bigNumbers[i];
            else
                halfSecond[i-10] = bigNumbers[i];
        }


        //for (int c = 0; c < 2; c++) {
            for (int b = 0; b < halfFirst.length; b++) {
                //if (c == 0)
                //    System.out.println(halfFirst[b]);
                //else
                    System.out.println(halfSecond[b]);
            }

        //}
    }
}
