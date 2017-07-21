package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        String romans = "IVXLCDM";
        int[] order = {1,5,10,50,100,500,1000};
        int sum = 0;

        // Process every char from string s
        for (int i = 0; i < s.length(); i++) {
            int pos = (romans.indexOf(s.toCharArray()[i]));
            int sign = 1;

            // if smaller value precedes larger one - change sign to negative (for ex.:
            // IX = (-1) * 1 + (1) * 10
            // XI = (1) * 10 + (1) * 1
            if (i + 1 < s.length() && pos < romans.indexOf(s.toCharArray()[i+1])) { sign = -1; }

            sum += sign * order[pos];
        }

        return sum;
    }
}
