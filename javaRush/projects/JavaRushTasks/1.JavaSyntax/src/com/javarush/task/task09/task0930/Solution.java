package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код

        //Initialize arrays
        boolean[] temp = new boolean[array.length];
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();

        // Separate numbers and text to arrays and populate "key-array" which remembers
        // what was on each position (text or number)
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                temp[i] = true;
                numbers.add((Integer.parseInt(array[i])));
            }
            else {
                temp[i] = false;
                words.add(array[i]);
            }
        }

        // Use built-in sorting procedures
        Collections.sort(words);
        Collections.sort(numbers);
        Collections.reverse(numbers);

        // Work on validator
        isGreaterThan("a","b");

        // Recreate array with already sorted data
        int nextNumber = 0;
        int nextWord = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i]) {
                array[i] = numbers.get(nextNumber).toString();
                nextNumber++;
            }
            else {
                array[i] = words.get(nextWord);
                nextWord++;
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
