package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        int result = 0;

        if (s != null && s.length() != 0) {
            int len = 0;
            char current = '\u0000';
            char previous = current;

            for (int i = 0; i < s.length(); i++) {
                current = s.charAt(i);

                if (current == previous) { len = 0; }

                len++;
                result = result > len ? result : len;
                previous = current;
            }
        }

        return result;
    }
}
