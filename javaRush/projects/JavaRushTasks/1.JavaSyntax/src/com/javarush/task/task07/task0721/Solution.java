package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] numbers = new int[20];
        for (int i = 0; i < 20; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        maximum = numbers[0];
        minimum  = numbers[0];
        for (int b = 0; b < numbers.length; b++) {
            maximum = (maximum < numbers[b]) ? numbers[b] : maximum;
            minimum = (minimum > numbers[b]) ?  numbers[b] : minimum;
        }

        System.out.println(maximum + " " + minimum);
    }
}
