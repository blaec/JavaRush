package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        // Initialize variables
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[15];
        int result = 0;
        String answer = "По обе стороны улицы проживает одинаковое число жителей.";

        // Fill array
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(bf.readLine());
        }

        // Calculation even/odd the condition
        for (int b = 0; b < numbers.length; b++) {
            if (b % 2 == 0)
                result += numbers[b];
            else
                result -= numbers[b];
        }

        // Return result
        if (result > 0)
            answer = "В домах с четными номерами проживает больше жителей.";
        else if (result < 0)
            answer = "В домах с нечетными номерами проживает больше жителей.";
        System.out.println(answer);
    }
}
