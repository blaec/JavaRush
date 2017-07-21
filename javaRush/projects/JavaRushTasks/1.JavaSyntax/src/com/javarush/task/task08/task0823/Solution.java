package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        s = s.toLowerCase();
        char[] sentence = s.toCharArray();
        if (Character.isLetter(sentence[0]))
            //sentence[0] = (char)(sentence[0] - 32);
            sentence[0] = Character.toUpperCase(sentence[0]);
        for (int i = 1; i < sentence.length; i++) {
            if (sentence[i-1] == ' ' && Character.isLetter(sentence[i])) {
                //sentence[i] = (char)(sentence[i] - 32);
                sentence[i] = Character.toUpperCase(sentence[i]);
            }
        }

        System.out.println(sentence);
    }
}
