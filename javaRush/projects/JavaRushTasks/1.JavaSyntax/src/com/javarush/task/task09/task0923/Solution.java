package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();

        ArrayList<String> alVowels = new ArrayList<>();
        ArrayList<String> alRest = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            if (isVowel(line[i])) {
                alVowels.add("" + line[i]);
            }
            else if (line[i] == ' ') {
                // do nothing
            }
            else {
                alRest.add("" + line[i]);
            }
        }

        for (int a = 0; a < alVowels.size(); a++) {
            System.out.print(alVowels.get(a) + " ");
        }
        System.out.println();
        for (int b = 0; b < alRest.size(); b++) {
            System.out.print(alRest.get(b) + " ");
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}