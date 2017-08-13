package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] test = getTokens("level22.lesson13.task01", ".");
        System.out.println(Arrays.toString(test));
    }
    public static String [] getTokens(String query, String delimiter) {
        List<String> temp = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            temp.add(tokenizer.nextToken());
        }

        String[] output = new String[temp.size()];
        return temp.toArray(output);

        /*
        * Better solution
        * StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        * String[] output = new String[tokenizer.countTokens()];
        *
        * for (int i=0; tokenizer.hasMoreElements(); i++) {
        *   output[i] = tokenizer.nextToken();
        * }
        *
        * return output;
        */

    }
}
