package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/*
Палиндром?
https://beginnersbook.com/2014/07/java-program-to-convert-decimal-to-hexadecimal/
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {

        // check if number is DEC
        int dec = 0;
        boolean isDec = true;
        try {
            dec = Integer.parseInt(number, 10);
        } catch (NumberFormatException e) {
            isDec = false;
        }

        // Convert DEC number to any other base 2...36
        Set<Integer> output = new HashSet<>();
        char base[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V', 'W', 'X','Y','Z'};
        if (isDec) {
            for (int i = 2; i <= 36; i++) {

                // 1.Process conversion
                int tempDec = dec;
                String val = "";
                int remainder = 0;
                while (tempDec > 0) {
                    remainder = tempDec % i;
                    val = base[remainder] + val;
                    tempDec = tempDec/i;
                }

                // 2.Process conversion
                String val2 = new StringBuilder(Integer.toString(dec, i)).toString();

                // If it's palindrome - add to list
                if (val.equals(new StringBuilder(val).reverse().toString())) output.add(i);
            }
        }

        return output;
    }
}